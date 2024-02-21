package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

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
	public String saveUser(UserEntity user , Model model) {
		
		if(!user.getPassword().equals(user.getConfirmpassword())) {
			model.addAttribute("passwordError", "Password and confirm passowerd must be same");			
			return"Signup";
		}
		
		user.setRoleId(3); // developer
		// encrypted Password logic start
		// read plain text password
		String plainPassword = user.getPassword();

		// encrypt plain text password

		String encPassword = passwordEncoder.encode(plainPassword); // Bcrypt

		// user -> Password -> set -> encPassword
		user.setPassword(encPassword);

		userRepo.save(user);

		return "redirect:/login";
	}

	@PostMapping("/authenticate")
	public String authenticate(UserEntity user, Model model) {
		UserEntity loggedInUser = userRepo.findByEmail(user.getEmail());
		System.out.println(loggedInUser);

		if (loggedInUser == null) {
			// credentials wrong
			model.addAttribute("error", "Invalid Credentials");
			return "Login";
		} else {

			boolean answer = passwordEncoder.matches(user.getPassword(), loggedInUser.getPassword());
			if (answer == false) {
				model.addAttribute("error", "Invalid Credentials");
				return "Login";
			} else if (loggedInUser.getRoleId() == 1) {
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
