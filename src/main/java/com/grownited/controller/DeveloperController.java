package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeveloperController {

	
	@GetMapping("/developerDashBoard")
	public String developerDashBoard() {
		return "DeveloperDashBoard";
	}
	
}
