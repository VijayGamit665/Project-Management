package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProjectUserEntity;
import com.grownited.repository.ProjectUserRepository;

@Controller
public class ProjectUserController {
	
	@Autowired
	ProjectUserRepository projectUserRepo;
	
	@GetMapping("/newProjectUser")
	public String newProjectUser() {
		return "NewProjectUser";
	}
	
	@PostMapping("/saveProjectUser")
	public String saveProjectUser(ProjectUserEntity projectUser ) {
		projectUserRepo.save(projectUser);
		return "redirect:/listProjectUser";
	}
	
	@GetMapping("/listProjectUser")
	public String listProjectUser(Model model) {
	List<ProjectUserEntity> projectUsers	= projectUserRepo.findAll();
	
	model.addAttribute("pu", projectUsers);
	return "ListProjectUser";
	
	
	
	}
	

}
