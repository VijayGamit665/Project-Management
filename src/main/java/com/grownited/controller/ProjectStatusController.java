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
	ProjectStatusRepository projectStatusrepo;
	
	@GetMapping("/newProjectStatus")
	public String newProjectStatus() {
		
		return "NewProjectStatus";//JSP
	}
	
	@PostMapping("/saveStatus")
	public String saveStatus(ProjectStatusEntity projectstatus) {
		
		projectStatusrepo.save(projectstatus);
		
		return "redirect:/lisProjectStatus";
	}
	
	@GetMapping("/lisProjectStatus")
	public String lisProjectStatus (Model model) {
		List<ProjectStatusEntity> Statuss = projectStatusrepo.findAll();
		model.addAttribute("s",Statuss);
		
		return"ListProjectStatus";
	}

}
