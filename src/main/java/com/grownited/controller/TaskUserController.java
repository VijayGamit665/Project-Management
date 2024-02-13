package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProjectStatusEntity;
import com.grownited.entity.TaskEntity;
import com.grownited.entity.TaskUserEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectStatusRepository;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.TaskUserRepository;
import com.grownited.repository.UserRepository;

@Controller
public class TaskUserController {
	
	@Autowired
	TaskUserRepository taskUserRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	TaskRepository taskRepo;
	@Autowired
	ProjectStatusRepository projectStatusRepo;
	
	@GetMapping("/newTaskUser")
	public String newTaskUser(Model model) {
		List<UserEntity> Users = userRepo.findAll();
	    List<TaskEntity> tasklist = taskRepo.findAll();
	    List<ProjectStatusEntity> statuslist = projectStatusRepo.findAll();
		model.addAttribute("Users", Users);
		model.addAttribute("tasklist", tasklist);
		model.addAttribute("statuslist", statuslist);
		return "NewTaskUser";
		
	}
	
	@PostMapping("/saveTaskUser")
	public String saveTaskUser(TaskUserEntity taskUser) {
		taskUserRepo.save(taskUser);
		return "redirect:/listTaskUser";
	}
	
	@GetMapping("/listTaskUser")
	public String listTaskUser(Model model) {
		 List<TaskUserEntity> taskUsers = taskUserRepo.findAll();	
		 model.addAttribute("tu",taskUsers);
		return "ListTaskUser";
	}

}
