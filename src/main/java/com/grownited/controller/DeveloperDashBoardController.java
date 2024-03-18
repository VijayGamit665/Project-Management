package com.grownited.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeveloperDashBoardController {

	@Autowired
	ProjectRepository projectRepo;

	LocalDate l = LocalDate.now();
	Integer month = l.getMonth().getValue();
	
	
	@GetMapping("/developerdashboard")
	public String adminDashBoard(HttpSession session, Model model) {

		UserEntity user = (UserEntity) session.getAttribute("user");
		
		Integer getUserProject = projectRepo.getUserProjectByUserId(user.getUserId());
		model.addAttribute("getUserProject", getUserProject);

		Integer getongoinUserproject = projectRepo.getongoinUserprojectByprojectstatusId(user.getUserId());
		model.addAttribute("getongoinUserproject", getongoinUserproject);

		Integer getuserpipelineproject = projectRepo.getuserpipelineprojectByprojectstatusId(user.getUserId());
		model.addAttribute("getuserpipelineproject", getuserpipelineproject);
		
		Integer userdueproject = projectRepo.getuserduoprojectByprojectstatusId(month, user.getUserId());
		model.addAttribute("userdueproject",userdueproject);

		return "DeveloperDashBoard";

	}
	
	
	@GetMapping("/usermyproject")
	public String userMyProject(HttpSession session, Model model , ProjectEntity project) {
		UserEntity user = (UserEntity) session.getAttribute("user");
			
		model.addAttribute("pu", projectRepo.getUserByUserId(user.getUserId()));
		model.addAttribute("hu", projectRepo.getholdUserByUserId(user.getUserId()));
		model.addAttribute("ru", projectRepo.getRevokeUserByUserId(user.getUserId()));
		return"MyProject";
	}
	
	@GetMapping("/userongoingproject")
	public String userOnGoingProject(HttpSession session, Model model , ProjectEntity project) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		List<ProjectEntity> userongoingproject = projectRepo.getUserongoinprojectByprojectstatusId(user.getUserId());
		model.addAttribute("userongoingproject",userongoingproject);
		 return"UserOnGoingProject";
	}

	@GetMapping("/userpipelineproject")
	public String userPipelineProject (HttpSession session, Model model , ProjectEntity project) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		List<ProjectEntity> userongoingproject = projectRepo.getUserpipelineprojectByprojectstatusId(user.getUserId());
		model.addAttribute("userongoingproject",userongoingproject);
		 return"UserPipelineProject";
	}
	
	@GetMapping("/userdueproject")
	public String userDueProject(HttpSession session, Model model , ProjectEntity project) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ProjectEntity> userdueproject = projectRepo.getuserDuoprojectByprojectstatusId(month, user.getUserId());
		model.addAttribute("userdueproject",userdueproject);
		
		return"UserDueProject";
	}


	
	
	

}
