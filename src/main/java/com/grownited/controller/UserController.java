package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/newUser")
	public String newUser() {
		
		return "User";//JSP
	}
	
	
	@PostMapping("/saveUser")
	public String saveUser(UserEntity user) {
		
		userRepo.save(user);
		
		return "redirect:/listUser";
	}
	
	@GetMapping("/listUser")
	public String listUser(Model model) {
		List<UserEntity> users = userRepo.findAll();
		model.addAttribute("u",users);
		
		return"ListUser";
	}

}
