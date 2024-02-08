package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProjectStatusEntity;
import com.grownited.repository.ProjectStatusRepository;

@Controller
public class ProjectStatusController {
	
	
	@Autowired
	ProjectStatusRepository projectStatusRepo;
	
	@GetMapping("/newProjectStatus")
	public String newPorjectStatus() {
		return "NewProjectStatus";
	}
	 
	@PostMapping("/saveProjectStatus")
	public String saveProjectStatus(ProjectStatusEntity statusEntity) {
		
		projectStatusRepo.save(statusEntity);
		
		return "redirect:/listProjectStatus";
	}
	
	@GetMapping("/listProjectStatus")
	public String listProjectStatus(Model model) {
		List<ProjectStatusEntity> status = projectStatusRepo.findAll();
		model.addAttribute("s",status);
		return "ListProjectStatus";
	}
	

}
