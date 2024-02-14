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
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.ProjectStatusRepository;


@Controller
public class ProjectController {
	
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ProjectStatusRepository projectStatusRepo;
	
	@GetMapping("/newProject")
	public String newProject(Model model) {
	List<ProjectStatusEntity> projectstatus = projectStatusRepo.findAll();
		model.addAttribute("projectstatus", projectstatus);
		return "NewProject";
	}
	 
	@PostMapping("/saveProject")
	public String saveProject(ProjectEntity project) {
		
		projectRepo.save(project);
		
		return "redirect:/listProject";
	}
	
	@GetMapping("/listProject")
	
	public String listProject(Model model) {
		
		List<ProjectEntity> projects = projectRepo.findAll();
		model.addAttribute("p",projects);
		return "ListProject";
	}
	
	@GetMapping("/deleteproject")
	public String deleteProject(@RequestParam("projectId") Integer projectId) {
		projectRepo.deleteById(projectId);
		return "redirect:/listProject";
	}
	

}
