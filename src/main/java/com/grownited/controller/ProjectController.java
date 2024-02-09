package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProjectEntity;
import com.grownited.repository.ProjectRepository;


@Controller
public class ProjectController {
	
	
	@Autowired
	ProjectRepository projectRepo;
	
	@GetMapping("/newProject")
	public String newProject() {
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
	

}
