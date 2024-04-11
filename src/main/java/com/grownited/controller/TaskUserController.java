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

import jakarta.servlet.http.HttpSession;

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
	public String newTaskUser(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		model.addAttribute("mytask", taskRepo.getUserByUserId(user.getUserId()));
		
		List<TaskEntity> tasklist = taskRepo.findAll();
		List<ProjectStatusEntity> statuslist = projectStatusRepo.findAll();
		model.addAttribute("tasklist", tasklist);
		model.addAttribute("statuslist", statuslist);
		if (user.getRoleId() == 2) {
			List<UserEntity> Users = userRepo.findByroleId();
			model.addAttribute("User", Users);

			return "ManagerNewTaskUser";

		} else {
			List<UserEntity> Users = userRepo.findAll();
			model.addAttribute("User", Users);
			return "NewTaskUser";
		}

	}

	@PostMapping("/saveTaskUser")
	public String saveTaskUser(TaskUserEntity taskUser) {
		taskUser.setAssignStatus(1);
		taskUserRepo.save(taskUser);
		return "redirect:/newTaskUser";
	}

	@GetMapping("/listTaskUser")
	public String listTaskUser(@RequestParam("taskId") Integer taskId, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		model.addAttribute("task", taskRepo.findById(taskId).get());
		model.addAttribute("pu", userRepo.getUserBytaskId(taskId));
		model.addAttribute("usersHold", userRepo.getUserBytaskIdHold(taskId));
		model.addAttribute("usersRevoke", userRepo.getUserBytaskIdRevoke(taskId));

		if (user.getRoleId() == 1) {

			return "ListTaskUser";

		} else if (user.getRoleId() == 2) {

			return "ManagerListTaskUser";

		} else {
			return "UserListTaskUser";

		}

	}

	@GetMapping("/deletetaskuser")
	public String deleteTaskUser(@RequestParam("taskUserId") Integer taskUserId) {
		taskUserRepo.deleteById(taskUserId);
		return "redirect:/listTaskUser";
	}

	@GetMapping("/taskrevoke")
	public String taskRevoke(@RequestParam("userId") Integer userId, @RequestParam("taskId") Integer taskId,
			@RequestParam("status") Integer status) {

		TaskUserEntity taskUser = taskUserRepo.findBytaskIdAndUserId(taskId, userId);
		taskUser.setAssignStatus(status);
		taskUserRepo.save(taskUser);

		return "redirect:/listTaskUser?taskId=" + taskId;
	}

}
