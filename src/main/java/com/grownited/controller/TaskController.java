package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.TaskEntity;
import com.grownited.repository.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	TaskRepository taskRepo;
	
	
	@GetMapping("/newTask")
	public String newTask() {
		return "NewTask";
	}
	
	
	@PostMapping("/saveTask")
	public String saveTask(TaskEntity task) {
		taskRepo.save(task);
		return "redirect:/listTask";
	}
	
	@GetMapping("/listTask")
	public String listTask(Model model) {
		
		List<TaskEntity> tasks = taskRepo.findAll();
		model.addAttribute("t", tasks);
		return "ListTask";
	}
	

}
