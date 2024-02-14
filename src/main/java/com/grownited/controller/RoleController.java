package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.RoleEntity;
import com.grownited.repository.RoleRepository;

@Controller
public class RoleController {
	
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping("/newRole")
	public String newRole() {
		
		return "NewRole";//JSP
	}
	
	@PostMapping("/saverole")
	public String saverole(RoleEntity role) {
	System.out.println(role.getRoleName());
	System.out.println(role.getRoleId());
	
	//insert
	
	roleRepo.save(role);//insert
	return "redirect:/listrole";
	
	}
	
	@GetMapping("/listrole")
	public String listRole(org.springframework.ui.Model model) {
		List<RoleEntity> roles = roleRepo.findAll();
		
		model.addAttribute("r",roles);
		return "ListRole";
	}
	
	@GetMapping("/deleterole")
	public String deleteRole(@RequestParam("roleId") Integer roleId) {
		roleRepo.deleteById(roleId);
		
		return "redirect:/listrole";
	}
}
