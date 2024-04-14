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
import com.grownited.entity.UserEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.ProjectStatusRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ModuleController {

	@Autowired
	ModuleRepository moduleRepo;

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	ProjectStatusRepository projectStatusRepo;

	@GetMapping("/newModule")
	public String newModule(Model model) {
		List<ProjectEntity> projectslist = projectRepo.findAll();
		List<ProjectStatusEntity> projectStatsulist = projectStatusRepo.findAll();
		model.addAttribute("projectslist", projectslist);
		model.addAttribute("projectStatsulist", projectStatsulist);
		return "NewModule";
	}

	@GetMapping("/directnewmodule")
	public String directNewModule(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ProjectEntity> projectslist = projectRepo.findAll();
		List<ProjectStatusEntity> projectStatsulist = projectStatusRepo.findAll();
		model.addAttribute("projectslist", projectslist);
		model.addAttribute("projectStatsulist", projectStatsulist);
		if (user.getRoleId() == 1) {
			return "DirectNewModule";
		} else {
			return "ManagerDirectNewModule";

		}
	}

	@PostMapping("/saveModule")
	public String saveModule(ModuleEntity module) {
		moduleRepo.save(module);
		return "redirect:/listmodule?projectId=" + module.getProjectId();
	}

	@GetMapping("/listmodule")
	public String listModule(@RequestParam("projectId") Integer projectId, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ModuleEntity> modules = moduleRepo.findByProjectId(projectId);
		ProjectEntity project = projectRepo.findById(projectId).get();
		model.addAttribute("m", modules);
		model.addAttribute("project", project);
		if (user.getRoleId() == 1) {
			return "ListModule";
		} else if (user.getRoleId() == 2) {

			return "ManagerMyModule";

		} else {

			return "UserMyModule";

		}

	}

	@GetMapping("/deletemodule")
	public String deleteModule(@RequestParam("moduleId") Integer moduleId) {
		int projectId = moduleRepo.findById(moduleId).get().getProjectId();
		moduleRepo.deleteById(moduleId);
		return "redirect:/listmodule?projectId=" + projectId;
	}

	@GetMapping("/editmodule")
	public String editModule(@RequestParam("moduleId") Integer moduleId, Model model) {
		ModuleEntity modules = moduleRepo.findById(moduleId).get();
		model.addAttribute("module", modules);
		model.addAttribute("projectStatuslist", projectStatusRepo.findAll());
		return "EditModule";
	}

	@GetMapping("/viewmodule")
	public String viewModule(@RequestParam("moduleId") Integer moduleId, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		ModuleEntity module = moduleRepo.findById(moduleId).get();
		model.addAttribute("module", module);
		if (user.getRoleId() == 1) {
			return "ViewModule";
		} else if (user.getRoleId() == 2) {

			return "ManagerViewModule";

		} else {

			return "UserViewModule";

		}

	}

}
