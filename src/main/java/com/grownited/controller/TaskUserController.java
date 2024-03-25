package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("User", Users);
		model.addAttribute("tasklist", tasklist);
		model.addAttribute("statuslist", statuslist);
		return "NewTaskUser";

	}

	@GetMapping("/managernewtaskuser")
	public String managerNewTaskUser(Model model) {
		List<UserEntity> Users = userRepo.findAll();
		List<TaskEntity> tasklist = taskRepo.findAll();
		List<ProjectStatusEntity> statuslist = projectStatusRepo.findAll();
		model.addAttribute("User", Users);
		model.addAttribute("tasklist", tasklist);
		model.addAttribute("statuslist", statuslist);
		return "ManagerNewTaskUser";

	}

	
	@PostMapping("/saveTaskUser")
	public String saveTaskUser(TaskUserEntity taskUser) {
		taskUser.setAssignStatus(1);
		taskUserRepo.save(taskUser);
		return "redirect:/newTaskUser";
	}

	@GetMapping("/listTaskUser")
	public String listTaskUser(@RequestParam("taskId") Integer taskId, Model model) {

		model.addAttribute("task", taskRepo.findById(taskId).get());
		model.addAttribute("pu", userRepo.getUserBytaskId(taskId));

		model.addAttribute("usersHold",userRepo.getUserBytaskIdHold(taskId));
		model.addAttribute("usersRevoke",userRepo.getUserBytaskIdRevoke(taskId));
		
		
		return "ListTaskUser";
	}

	@GetMapping("/managerlisttaskuser")
	public String managerListTaskUser(@RequestParam("taskId") Integer taskId, Model model) {

		model.addAttribute("task", taskRepo.findById(taskId).get());
		model.addAttribute("pu", userRepo.getUserBytaskId(taskId));

		model.addAttribute("usersHold",userRepo.getUserBytaskIdHold(taskId));
		model.addAttribute("usersRevoke",userRepo.getUserBytaskIdRevoke(taskId));
		
		
		return "ManagerListTaskUser";
	}

	@GetMapping("/userlisttaskuser")
	public String userListTaskUser(@RequestParam("taskId") Integer taskId, Model model) {

		model.addAttribute("task", taskRepo.findById(taskId).get());
		model.addAttribute("pu", userRepo.getUserBytaskId(taskId));

		model.addAttribute("usersHold",userRepo.getUserBytaskIdHold(taskId));
		model.addAttribute("usersRevoke",userRepo.getUserBytaskIdRevoke(taskId));
		
		
		return "UserListTaskUser";
	}

	
	
	@GetMapping("/deletetaskuser")
	public String deleteTaskUser(@RequestParam("taskUserId") Integer taskUserId) {
		taskUserRepo.deleteById(taskUserId);
		return "redirect:/listTaskUser";
	}
	
	@GetMapping("/taskrevoke")
	public String taskRevoke(@RequestParam("userId") Integer userId,@RequestParam("taskId") Integer taskId,@RequestParam("status") Integer status) {
		
		TaskUserEntity taskUser = taskUserRepo.findBytaskIdAndUserId(taskId,userId);
		taskUser.setAssignStatus(status);
		taskUserRepo.save(taskUser);
		
		return"redirect:/listTaskUser?taskId="+taskId;
	}
	

}
