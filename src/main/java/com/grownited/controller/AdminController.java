package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	
	
	
	@GetMapping("/adminDashboard")
	public String adminDashboard() {
		
		return "AdminDashBoard";
	}
	
	
	
}
