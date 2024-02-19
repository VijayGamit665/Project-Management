package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectManagerController {
	
	@GetMapping("/projectManagerDashBoard")
	public String projectManagerDashBoard() {
		return "ProjectManagerDashBoard";
	}

}
