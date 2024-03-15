package com.grownited.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.ProjectEntity;
import com.grownited.repository.ProjectRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminDashBoardController {

	@Autowired
	ProjectRepository projectRepo;

	LocalDate l = LocalDate.now();
	Integer month = l.getMonth().getValue();
	
	@GetMapping("/admindashboard")
	public String adminDashBoard(HttpSession session, Model model) {

		Integer getTotalProject = projectRepo.getprojectcount();
		model.addAttribute("getTotalProject", getTotalProject);

		Integer getongoinproject = projectRepo.getongoinprojectByprojectstatusId();
		model.addAttribute("getongoinproject", getongoinproject);

		Integer getpipelineproject = projectRepo.getpipelineprojectByprojectstatusId();
		model.addAttribute("getpipelineproject", getpipelineproject);

		Integer getCompletedprojects = projectRepo.getCompletedprojectBymonth(month);
		model.addAttribute("getCompletedprojects", getCompletedprojects);

		return "AdminDashBoard";

	}

	@GetMapping("/dueproject")
	public String dueProject(ProjectEntity project, Model model) {


		List<ProjectEntity> dueProject = projectRepo.getdueCompletedprojectBymonth(month);
		model.addAttribute("dueProject", dueProject);
		return "AdminDueProject";
	}
	
	@GetMapping("/ongoingproject")
	public String onGoingProject(ProjectEntity project,Model model) {
		
		 List<ProjectEntity> ongoingproject = projectRepo.getongoingprojectsByprojectstatusId(month);
		 model.addAttribute("ongoingproject",ongoingproject);
		return "AdminOnGoingProject";
	}
	
	@GetMapping("/pipelineprojects")
	public String pipelineProjects(ProjectEntity project, Model model) {
		
	List<ProjectEntity>	pipelineproject = projectRepo.getpipelineprojectsByprojectstatusId(month);
	model.addAttribute("pipelineproject",pipelineproject);
	return"AdminPipelineProject";
	
	}
	

}
