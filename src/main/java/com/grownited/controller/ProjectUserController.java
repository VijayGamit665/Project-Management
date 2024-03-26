package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.ProjectUserEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.ProjectUserRepository;
import com.grownited.repository.RoleRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProjectUserController {

	@Autowired
	ProjectUserRepository projectUserRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	RoleRepository roleRepo;

	@GetMapping("/newProjectUser")
	public String newProjectUser(ProjectEntity project, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		
		if (user.getRoleId() == 1) {

			List<UserEntity> manager = userRepo.findBymroleId();
			model.addAttribute("managers", manager);
			List<ProjectEntity> projectlists = projectRepo.findAll();
			model.addAttribute("projectlist", projectlists);

			return "NewProjectUser";

		} else {

			model.addAttribute("projectlist", projectRepo.getUserByUserId(user.getUserId()));
			List<UserEntity> developer = userRepo.findByroleId();
			model.addAttribute("developers", developer);
			return "ManagerNewProjectUser";
		}

	}

	@PostMapping("/saveProjectUser")
	public String saveProjectUser(ProjectUserEntity projectUser, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		projectUser.setAssignStatus(1);
		projectUserRepo.save(projectUser);

		if (user != null) {
			if (user.getRoleId() == 2) {
				return "redirect:/managernewprojectuser";
			} else {
				return "redirect:/newProjectUser";
			}

		} else {

			return "login";
		}

	}

	@GetMapping("/listProjectUser")
	public String listProjectUser(@RequestParam("projectId") Integer projectId, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		model.addAttribute("project", projectRepo.findById(projectId).get());
		model.addAttribute("pu", userRepo.getUserByProjectId(projectId));

		model.addAttribute("usersHold", userRepo.getUserByprojectIdHold(projectId));
		model.addAttribute("usersRevoke", userRepo.getUserByprojectIdRevoke(projectId));

		if (user.getRoleId() == 1) {

			return "ListProjectUser";

		} else if (user.getRoleId() == 2) {

			return "ManagerListProjectUser";

		} else {

			return "UserListProjectUser";

		}

	}

	@GetMapping("/deleteprojectuser")
	public String deleteProjectUser(@RequestParam("projectId") Integer projectId, Model model) {
		projectUserRepo.deleteById(projectId);

		return "redirect:/listProjectUser";
	}

	@GetMapping("/projectrevoke")
	public String projectRevoke(@RequestParam("userId") Integer userId, @RequestParam("projectId") Integer projectId,
			@RequestParam("status") Integer status) {

		ProjectUserEntity projectUser = projectUserRepo.findByprojectIdAndUserId(projectId, userId);
		projectUser.setAssignStatus(status);
		projectUserRepo.save(projectUser);

		return "redirect:/listProjectUser?projectId=" + projectId;
	}

}
