package com.grownited.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.DailyEffortsEntity;
import com.grownited.entity.ModuleEntity;
import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.DailyEffortsRepository;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectStatusRepository;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DailyEffortsController {

	@Autowired
	TaskRepository taskRepo;

	@Autowired
	ProjectStatusRepository projectStatusRepo;

	@Autowired
	DailyEffortsRepository dailyeffortsRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	ModuleRepository moduleRepo;

	LocalTime Time = LocalTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
	String currentTime = Time.format(formatter);

	LocalDate Date = LocalDate.now();

	@GetMapping("/dailyeffortslog")
	public String dailyEffortsLog(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		model.addAttribute("mytask", taskRepo.getUserByUserId(user.getUserId()));
		model.addAttribute("status", projectStatusRepo.findAll());
		model.addAttribute("user", user);
		return "UserDailyEffortsLog";
	}

	@PostMapping("/savedailyefforts")
	public String saveDailyEfforts(DailyEffortsEntity dailyefforts, Model model) {

		dailyeffortsRepo.save(dailyefforts);

		updateTaskStatus(dailyefforts.getTaskId());

		return "redirect:/listdailyefforts";
	}

	@GetMapping("/listdailyefforts")
	public String listDailyEfforts(Model model) {
		List<DailyEffortsEntity> logs = dailyeffortsRepo.findAll();
		model.addAttribute("logs", logs);
		return "UserlistDailyEfforts";
	}

	private void updateTaskStatus(Integer taskId) {

		List<DailyEffortsEntity> latestLogs = dailyeffortsRepo.findTopByTaskIdOrderByDailyDateDesc(taskId);

		if (!latestLogs.isEmpty()) {
			DailyEffortsEntity latestLog = latestLogs.get(0);
			TaskEntity task = taskRepo.findById(taskId).orElse(null);
			Integer currentTotalUtilizedHours = task.getTotalUtilizedHours();
			Integer latestLogTotalUtilizedHours = latestLog.getTotalUtilizedHours();
			Integer newTotalUtilizedHours = currentTotalUtilizedHours + latestLogTotalUtilizedHours;

			if (task != null) {
				// Update task status with the status from the latest daily effort log
				task.setStatusId(latestLog.getStatusId());
				task.setTotalUtilizedHours(newTotalUtilizedHours);
				taskRepo.save(task);
				updateModuleStatus(task.getModuleId());

			}
		}

	}

	private void updateModuleStatus(Integer moduleId) {

		List<TaskEntity> tasks = taskRepo.getNotCompeletedTask(moduleId);
		ModuleEntity module = moduleRepo.findById(moduleId).orElse(null);
		Integer totalUtilizedHours = taskRepo.getTotalUtilizedHoursSumByModuleId(moduleId);
		ModuleEntity modules = moduleRepo.findById(moduleId).get();
		Integer currentTotalUtilizedHours = modules.getTotalUtilizedHours();
		Integer newTotalUtilizedHours = currentTotalUtilizedHours + totalUtilizedHours;
		Integer statusId = 5;
		if (tasks.size() == 0) {
			module.setStatusId(statusId);
			module.setTotalUtilizedHours(newTotalUtilizedHours);
			moduleRepo.save(module);
		} else {

			module.setTotalUtilizedHours(newTotalUtilizedHours);
			moduleRepo.save(module);

		}
	}

}
