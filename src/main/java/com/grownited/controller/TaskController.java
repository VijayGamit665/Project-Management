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
import com.grownited.entity.UserEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.ProjectStatusRepository;
import com.grownited.repository.TaskRepository;

import jakarta.servlet.http.HttpSession;

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
	public String deleteTask(@RequestParam("taskId") Integer taskId) {
		int moduleId = taskRepo.findById(taskId).get().getModuleId();
		taskRepo.deleteById(taskId);
		return "redirect:/listTask?moduleId="+moduleId;
	}
	
	@GetMapping("/myTask")
	public String myTask(@RequestParam("moduleId") Integer moduleId,Model model , HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		ModuleEntity modules = moduleRepo.findById(moduleId).get();
		model.addAttribute("m", modules);
		ProjectEntity projects = projectRepo.findById(modules.getProjectId()).get();
		model.addAttribute("p", projects);
		model.addAttribute("task", taskRepo.getUserByUserId(user.getUserId()));
		model.addAttribute("revoketask",taskRepo.getRevokeUserByUserId(user.getUserId()));
		model.addAttribute("holdtask",taskRepo.getHoldUserByUserId(user.getUserId()));
		return"MyTask";
	}
	
	@GetMapping("/edittask")
	public String editTask(@RequestParam("taskId") Integer taskId, Model model) {
	 	TaskEntity task = taskRepo.findById(taskId).get();
	 	model.addAttribute("task",task);
	    model.addAttribute("projectStatuslist", projectStatusRepo.findAll());
		
		return"EditTask";
	}

}
