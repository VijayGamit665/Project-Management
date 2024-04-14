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

	@GetMapping("/directnewtask")
	public String directNewTask(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ProjectEntity> projectss = projectRepo.findAll();
		List<ModuleEntity> modules = moduleRepo.findAll();
		List<ProjectStatusEntity> statuss = projectStatusRepo.findAll();
		model.addAttribute("projects", projectss);
		model.addAttribute("module", modules);
		model.addAttribute("statuss", statuss);

		if (user.getRoleId() == 1) {

			return "DirectNewTask";

		} else {
			return "ManagerDirectNewTask";

		}
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
		return "redirect:/listTask?moduleId=" + moduleId;
	}

	@GetMapping("/mytask")
	public String myTask(@RequestParam("moduleId") Integer moduleId, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		ModuleEntity modules = moduleRepo.findById(moduleId).get();
		model.addAttribute("m", modules);
		ProjectEntity projects = projectRepo.findById(modules.getProjectId()).get();
		model.addAttribute("p", projects);
		model.addAttribute("task", taskRepo.getUserByUserId(user.getUserId()));
		model.addAttribute("revoketask", taskRepo.getRevokeUserByUserId(user.getUserId()));
		model.addAttribute("holdtask", taskRepo.getHoldUserByUserId(user.getUserId()));

		if (user.getRoleId() == 2) {

			return "ManagerMyTask";

		} else {

		}
		return "UserMyTask";
	}

	@GetMapping("/edittask")
	public String editTask(@RequestParam("taskId") Integer taskId, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		TaskEntity task = taskRepo.findById(taskId).get();
		model.addAttribute("task", task);
		model.addAttribute("projectStatuslist", projectStatusRepo.findAll());

		if (user.getRoleId() == 1) {

			return "EditTask";

		} else {
			return "ManagerEditTask";
		}

	}

	@GetMapping("/directmytask")
	public String directMyTask(@RequestParam("userId") Integer userId, Model model) {

		List<TaskEntity> task = taskRepo.getUserByUserId(userId);
		List<TaskEntity> revoketask = taskRepo.getRevokeUserByUserId(userId);
		List<TaskEntity> holdtask = taskRepo.getHoldUserByUserId(userId);
		model.addAttribute("task", task);
		model.addAttribute("revoketask", revoketask);
		model.addAttribute("holdtask", holdtask);

		return "UserMyTask";
	}

	@GetMapping("/viewtask")
	public String viewTask(@RequestParam("taskId") Integer taskId, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		TaskEntity task = taskRepo.findById(taskId).get();
		model.addAttribute("task", task);
		if (user.getRoleId() == 1) {

			return "ViewTask";

		} else if (user.getRoleId() == 2) {
			return "ManagerViewTask";
		} else {
			return "UserViewTask";
		}

	}

}
