package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.bean.UserBean;



@Controller
public class SessionController {
	
	@GetMapping("/")
	public String welcome () {
		return "Welcome"; // jsp name
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(UserBean user) {
		// read
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		
		
		System.out.println("SaveUser");
		return "Home";
	}

}
