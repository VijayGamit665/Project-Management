package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.ProjectStatusEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.ProjectStatusRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProjectController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	ProjectStatusRepository projectStatusRepo;

	@GetMapping("/newProject")
	public String newProject(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		List<ProjectStatusEntity> projectstatus = projectStatusRepo.findAll();
		model.addAttribute("projectstatus", projectstatus);

		if (user.getRoleId() == 1) {
			return "NewProject";
		} else {
			return "ManagerNewProject";
		}

	}

	@PostMapping("/saveProject")
	public String saveProject(ProjectEntity project) {

		projectRepo.save(project);		
		return "redirect:/listProject";
	}

	@GetMapping("/listProject")
	public String listProject(Model model) {

		List<ProjectEntity> projects = projectRepo.findAll();
		model.addAttribute("p", projects);
		return "ListProject";
	}

	@GetMapping("/deleteproject")
	public String deleteProject(@RequestParam("projectId") Integer projectId) {
		projectRepo.deleteById(projectId);
		return "redirect:/listProject";
	}

	@GetMapping("/viewproject")
	public String viewProject(@RequestParam("projectId") Integer projectId, Model model) {
		ProjectEntity projects = projectRepo.findById(projectId).get();
		model.addAttribute("projects", projects);
		return "ViewProject";
	}

	@GetMapping("/editproject")
	public String editproject(@RequestParam("projectId") Integer projectId, Model model) {
		ProjectEntity projects = projectRepo.findById(projectId).get();
		model.addAttribute("projectstatuslist", projectStatusRepo.findAll());
		model.addAttribute("project", projects);

		return "EditProject";
	}

}
