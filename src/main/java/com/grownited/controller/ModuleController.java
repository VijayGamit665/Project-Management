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
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.ProjectStatusRepository;

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

	@PostMapping("/saveModule")
	public String saveModule(ModuleEntity module) {
		 moduleRepo.save(module);
		return "redirect:/listmodule?projectId="+module.getProjectId();
	}
	
	@GetMapping("/listmodule")
	public String listModule(@RequestParam("projectId") Integer projectId, Model model) {
	 	 List<ModuleEntity> modules = moduleRepo.findByProjectId(projectId);
	 	 ProjectEntity project = projectRepo.findById(projectId).get();
	 	 model.addAttribute("m", modules);
	 	 model.addAttribute("project", project);
	 	 return "ListModule";
    }
	
	@GetMapping("/deletemodule")
	public String deleteModule(@RequestParam("moduleId") Integer moduleId) {
		moduleRepo.deleteById(moduleId);
		return "redirect:/listModule";
	}

}
