package com.grownited.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.ProjectEntity;
import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.TaskRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProjectManagerDashBoardController {

	@Autowired
	ProjectRepository projectRepo;

	LocalDate l = LocalDate.now();
	Integer month = l.getMonth().getValue();

	@Autowired
	ModuleRepository moduleRepo;

	@Autowired
	TaskRepository taskRepo;

	@GetMapping("/projectManagerDashBoard")
	public String projectManagerDashBoard(HttpSession session, Model model) {

		UserEntity user = (UserEntity) session.getAttribute("user");

		Integer getUserProject = projectRepo.getUserProjectByUserId(user.getUserId());
		model.addAttribute("getUserProject", getUserProject);

		Integer getongoinUserproject = projectRepo.getongoinUserprojectByprojectstatusId(user.getUserId());
		model.addAttribute("getongoinUserproject", getongoinUserproject);

		Integer getuserpipelineproject = projectRepo.getuserpipelineprojectByprojectstatusId(user.getUserId());
		model.addAttribute("getuserpipelineproject", getuserpipelineproject);

		Integer userdueproject = projectRepo.getuserduoprojectByprojectstatusId(month, user.getUserId());
		model.addAttribute("userdueproject", userdueproject);

		List<ProjectEntity> projects = projectRepo.getchartsUserByUserId(user.getUserId());
		String projectName = "";
		String estimatedHr = "";
		String totalUtilizedHours = "";
		for (ProjectEntity p : projects) {
			projectName = projectName + "'" + p.getTitle() + "',";
			estimatedHr = estimatedHr + p.getEstimatedHours() + ",";
			totalUtilizedHours = totalUtilizedHours + p.getTotalUtilizedHours() + ",";
		}
		model.addAttribute("projectName", projectName);
		model.addAttribute("estimatedHr", estimatedHr);
		model.addAttribute("totalUtilizedHours", totalUtilizedHours);

		List<ModuleEntity> modules = moduleRepo.findAll();
		String moduleName = "";
		String mestimatedHr = "";
		String mtotalUtilizedHours = "";
		for (ModuleEntity m : modules) {
			moduleName = moduleName + "'" + m.getModuleName() + "',";
			mestimatedHr = mestimatedHr + m.getEstimatedHours() + ",";
			mtotalUtilizedHours = mtotalUtilizedHours + m.getTotalUtilizedHours() + ",";
		}
		model.addAttribute("moduleName", moduleName);
		model.addAttribute("mestimatedHr", mestimatedHr);
		model.addAttribute("mtotalUtilizedHours", mtotalUtilizedHours);

		List<TaskEntity> tasks = taskRepo.getchartsUserByUserId(user.getUserId());
		String taskName = "";
		String testimatedHr = "";
		String ttotalUtilizedHours = "";
		for (TaskEntity t : tasks) {
			taskName = taskName + "'" + t.getTitle() + "',";
			testimatedHr = testimatedHr + t.getEstimatedHours() + ",";
			ttotalUtilizedHours = ttotalUtilizedHours + t.getTotalUtilizedHours() + ",";
		}

		model.addAttribute("taskName", taskName);
		model.addAttribute("testimatedHr", testimatedHr);
		model.addAttribute("ttotalUtilizedHours", ttotalUtilizedHours);

		return "ProjectManagerDashBoard";
	}

	@GetMapping("/managermyproject")
	public String managerMyProject(HttpSession session, Model model, ProjectEntity project) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		model.addAttribute("pu", projectRepo.getUserByUserId(user.getUserId()));
		model.addAttribute("hu", projectRepo.getholdUserByUserId(user.getUserId()));
		model.addAttribute("ru", projectRepo.getRevokeUserByUserId(user.getUserId()));

		return "ManagerMyProject";
	}

	@GetMapping("/managerongoingproject")
	public String managerOnGoingProject(HttpSession session, Model model, ProjectEntity project) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		List<ProjectEntity> userongoingproject = projectRepo.getUserongoinprojectByprojectstatusId(user.getUserId());
		model.addAttribute("userongoingproject", userongoingproject);
		return "ManagerOnGoingProject";
	}

	@GetMapping("/managerpipelineproject")
	public String userPipelineProject(HttpSession session, Model model, ProjectEntity project) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		List<ProjectEntity> userpipelineproject = projectRepo.getUserpipelineprojectByprojectstatusId(user.getUserId());
		model.addAttribute("userpipelineproject", userpipelineproject);
		return "ManagerPipelineProject";
	}

	@GetMapping("/managerdueproject")
	public String managerDueProject(HttpSession session, Model model, ProjectEntity project) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ProjectEntity> userdueproject = projectRepo.getuserDuoprojectByprojectstatusId(month, user.getUserId());
		model.addAttribute("userdueproject", userdueproject);

		return "ManagerDueProject";
	}

}
