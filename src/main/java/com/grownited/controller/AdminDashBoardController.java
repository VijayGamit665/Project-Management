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
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.TaskRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminDashBoardController {

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	ModuleRepository moduleRepo;

	@Autowired
	TaskRepository taskRepo;

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

		List<ProjectEntity> projects = projectRepo.findAll();
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

		List<TaskEntity> tasks = taskRepo.findAll();
		String taskName = "";
		String testimatedHr = "";
		String ttotalUtilizedHours = "";
		for(TaskEntity t : tasks) {
			taskName = taskName + "'"+ t.getTitle()+"',";
			testimatedHr = testimatedHr + t.getEstimatedHours()+",";
			ttotalUtilizedHours = ttotalUtilizedHours + t.getTotalUtilizedHours()+",";
		}
		 
		model.addAttribute("taskName",taskName);
		model.addAttribute("testimatedHr",testimatedHr);
		model.addAttribute("ttotalUtilizedHours",ttotalUtilizedHours);

		return "AdminDashBoard";

	}

	@GetMapping("/dueproject")
	public String dueProject(ProjectEntity project, Model model) {

		List<ProjectEntity> dueProject = projectRepo.getdueCompletedprojectBymonth(month);
		model.addAttribute("dueProject", dueProject);
		return "AdminDueProject";
	}

	@GetMapping("/ongoingproject")
	public String onGoingProject(ProjectEntity project, Model model) {

		List<ProjectEntity> ongoingproject = projectRepo.getongoingprojectsByprojectstatusId(month);
		model.addAttribute("ongoingproject", ongoingproject);
		return "AdminOnGoingProject";
	}

	@GetMapping("/pipelineprojects")
	public String pipelineProjects(ProjectEntity project, Model model) {

		List<ProjectEntity> pipelineproject = projectRepo.getpipelineprojectsByprojectstatusId(month);
		model.addAttribute("pipelineproject", pipelineproject);
		return "AdminPipelineProject";

	}

	@GetMapping("/charts")
	public String charts(Model model) {

		List<ProjectEntity> projects = projectRepo.findAll();
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
		return "Charts";
	}

}
