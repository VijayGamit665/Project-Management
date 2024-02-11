package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.TaskUserEntity;
import com.grownited.repository.TaskUserRepository;

@Controller
public class TaskUserController {
	
	@Autowired
	TaskUserRepository taskUserRepo;
	
	@GetMapping("/newTaskUser")
	public String newTaskUser() {
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
