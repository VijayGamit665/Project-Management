package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SessionController {
	
	@GetMapping("/welcome")
	public String welcome () {
		return "Welcome"; // jsp name
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}

}
