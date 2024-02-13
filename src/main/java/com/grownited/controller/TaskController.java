package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.ProjectEntity;
import com.grownited.entity.ProjectStatusEntity;
import com.grownited.entity.TaskEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.ProjectStatusRepository;
import com.grownited.repository.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	TaskRepository taskRepo;
	
	@Autowired
	ModuleRepository moduleRepo;
	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	ProjectStatusRepository projectStatusRepo;
	
	@GetMapping("/newTask")
	public String newTask(Model model) {
	List<ModuleEntity> modulelist = moduleRepo.findAll();
	List<ProjectEntity> projectlist = projectRepo.findAll();
	List<ProjectStatusEntity> statuss = projectStatusRepo.findAll();
	model.addAttribute("modulelist", modulelist);
	model.addAttribute("projectlist", projectlist);
	model.addAttribute("statuss", statuss);
		
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
