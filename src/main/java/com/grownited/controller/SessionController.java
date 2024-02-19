package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
public class SessionController {

	@Autowired
	UserRepository userRepo;

	@GetMapping("/")
	public String welcome() {
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

	@PostMapping("/signup")
	public String saveUser(UserEntity user) {
		user.setRoleId(3);
		userRepo.save(user);

		return "redirect:/login";
	}

	@PostMapping("/authenticate")
	public String authenticate(UserEntity user, Model model) {
		UserEntity loggedInUser = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		System.out.println(loggedInUser);

		if (loggedInUser == null) {
			// credentials wrong
			model.addAttribute("error", "Invalid Credentials");
			return "Login";
		} else {
			if (loggedInUser.getRoleId() == 1) {
				// Admin
				return "AdminDashBoard";
			} else if (loggedInUser.getRoleId() == 2) {
				// Project Manager
				return "ProjectManagerDashBoard";
			} else if (loggedInUser.getRoleId() == 3) {
				// Developer
				return "DeveloperDashboard";
			} else {
				return "Login";
			}
		}
	}
}
