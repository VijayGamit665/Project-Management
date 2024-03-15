package com.grownited.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.repository.ProjectRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProjectManagerDashBoardController {
	
	@Autowired
	ProjectRepository projectRepo;

	LocalDate l = LocalDate.now();
	Integer month = l.getMonth().getValue();

	
	@GetMapping("/projectManagerDashBoard")
	public String projectManagerDashBoard(HttpSession session, Model model) {
		
		Integer getTotalProject = projectRepo.getprojectcount();
		model.addAttribute("getTotalProject", getTotalProject);

		Integer getongoinproject = projectRepo.getongoinprojectByprojectstatusId();
		model.addAttribute("getongoinproject", getongoinproject);

		Integer getpipelineproject = projectRepo.getpipelineprojectByprojectstatusId();
		model.addAttribute("getpipelineproject", getpipelineproject);

		Integer getCompletedprojects = projectRepo.getCompletedprojectBymonth(month);
		model.addAttribute("getCompletedprojects", getCompletedprojects);

			
		return "ProjectManagerDashBoard";
	}

}
