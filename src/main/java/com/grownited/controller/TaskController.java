package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String newTask(@RequestParam("moduleId") Integer moduleId, Model model) {
		ModuleEntity modules = moduleRepo.findById(moduleId).get();
		ProjectEntity projects = projectRepo.findById(modules.getProjectId()).get();

		List<ProjectStatusEntity> statuss = projectStatusRepo.findAll();
		model.addAttribute("module", modules);
		model.addAttribute("projects", projects);
		model.addAttribute("statuss", statuss);

		return "NewTask";
	}

	@PostMapping("/saveTask")
	public String saveTask(TaskEntity task) {
		taskRepo.save(task);
		return "redirect:/listTask?moduleId=" + task.getModuleId();
	}

	@GetMapping("/listTask")
	public String listTask(@RequestParam("moduleId") Integer moduleId, Model model) {
		List<TaskEntity> tasks = taskRepo.findByModuleId(moduleId);
		ModuleEntity modules = moduleRepo.findById(moduleId).get();
		ProjectEntity projects = projectRepo.findById(modules.getProjectId()).get();
		model.addAttribute("t", tasks);
		model.addAttribute("m", modules);
		model.addAttribute("p", projects);
		return "ListTask";
	}

	@GetMapping("/deletetask")
	public String deleteTask(@RequestParam("taskId") Integer taskId , TaskEntity task) {
		taskRepo.deleteById(taskId);
		return "redirect:/listTask?moduleId="+ task.getModuleId();
	}
	
	@GetMapping("/myTask")
	public String myTask(@RequestParam("userId") Integer userId, Model model) {
		model.addAttribute("task", taskRepo.getUserByUserId(userId));
		return"MyTask";
	}

}
