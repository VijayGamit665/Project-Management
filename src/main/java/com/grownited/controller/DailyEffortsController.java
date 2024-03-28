package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.DailyEffortsEntity;
import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.DailyEffortsRepository;
import com.grownited.repository.ProjectStatusRepository;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.UserRepository;


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
	
	@GetMapping("/dailyeffortslog")
	public String dailyEffortsLog(Model model) {
		List<TaskEntity> mytask = taskRepo.findAll();
		model.addAttribute("mytask", mytask);
		model.addAttribute("status", projectStatusRepo.findAll());
		List<UserEntity> users = userRepo.findAll();
		model.addAttribute("users",users);
		return "UserDailyEffortsLog";
	}

	@PostMapping("/savedailyefforts")
	public String saveDailyEfforts(DailyEffortsEntity dailyefforts, Model model) {

		dailyeffortsRepo.save(dailyefforts);
		return "redirect:/listdailyefforts";
	}
	
	@GetMapping("/listdailyefforts")
	public String listDailyEfforts(Model model) {
			List<DailyEffortsEntity> logs = dailyeffortsRepo.findAll();
			model.addAttribute("logs",logs);
			System.out.println(logs.size());
		return"UserlistDailyEfforts";
	}
	
	
	
}
