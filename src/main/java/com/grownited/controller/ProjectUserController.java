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
import com.grownited.repository.UserRepository;

@Controller
public class ProjectUserController {
	
	@Autowired
	ProjectUserRepository projectUserRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProjectRepository projectRepo;
	
	@GetMapping("/newProjectUser")
	public String newProjectUser(Model model) {
		List<UserEntity> users = userRepo.findAll();
		List<ProjectEntity> projectlist = projectRepo.findAll();
		model.addAttribute("users", users);
		model.addAttribute("projectlist", projectlist);
	
		return "NewProjectUser";
	}
	
	@PostMapping("/saveProjectUser")
	public String saveProjectUser(ProjectUserEntity projectUser) {
		projectUserRepo.save(projectUser);
		return "redirect:/listProjectUser";
	}
	
	@GetMapping("/listProjectUser")
	public String listProjectUser(Model model) {
	List<ProjectUserEntity> projectUsers	= projectUserRepo.findAll();
	
	model.addAttribute("pu", projectUsers);
	return "ListProjectUser";
	}
	
	@GetMapping("/deleteprojectuser")
	public String deleteProjectUser(@RequestParam("projectUserId") Integer projectUserId) {
		projectUserRepo.deleteById(projectUserId);
		return "redirect:/listProjectUser";
	}
	

}
