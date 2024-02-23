package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.RoleEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.RoleRepository;
import com.grownited.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping("/newUser")
	public String newUser(Model model) {
		
	List<RoleEntity> roleList = roleRepo.findAll();
	model.addAttribute("roleList",roleList);
		
		return "NewUser";//JSP
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
	
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		userRepo.deleteById(userId);
		return "redirect:/listUser";
	}

}
