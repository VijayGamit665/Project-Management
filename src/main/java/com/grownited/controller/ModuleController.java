package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ModuleEntity;
import com.grownited.repository.ModuleRepository;

@Controller
public class ModuleController {

	@Autowired
	ModuleRepository moduleRepo;
	
	@GetMapping("/newModule")
	public String newModule() {
		return "NewModule";
	}

	@PostMapping("/saveModule")
	public String saveModule(ModuleEntity module) {
		 moduleRepo.save(module);
		return "redirect:/listModule";
	}
	
	@GetMapping("/listModule")
	public String listModule(Model model) {
	 	 List<ModuleEntity> modules = moduleRepo.findAll();
	 	 model.addAttribute("m", modules);
	 	 return "ListModule";

}

}
