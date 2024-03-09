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
	public String newProjectUser(ProjectEntity project, UserEntity user, Model model) {

		List<UserEntity> projectusers = userRepo.findAll();
		List<ProjectEntity> projectlists = projectRepo.findAll();
		model.addAttribute("puser", projectusers);
		model.addAttribute("projectlist", projectlists);

		return "NewProjectUser";
	}

	@PostMapping("/saveProjectUser")
	public String saveProjectUser(ProjectUserEntity projectUser) {
		projectUser.setAssignStatus(1);
		projectUserRepo.save(projectUser);
		return "redirect:/newProjectUser";
	}

	@GetMapping("/listProjectUser")
	public String listProjectUser(@RequestParam("projectId") Integer projectId, Model model) {

		model.addAttribute("project", projectRepo.findById(projectId).get());
		model.addAttribute("pu", userRepo.getUserByProjectId(projectId));

		return "ListProjectUser";
	}

	@GetMapping("/deleteprojectuser")
	public String deleteProjectUser(@RequestParam("projectId") Integer projectId, Model model) {
		projectUserRepo.deleteById(projectId);
		
		return "redirect:/listProjectUser";
	}

}
