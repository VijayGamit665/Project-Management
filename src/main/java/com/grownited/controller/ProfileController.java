package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {

	@GetMapping("/profile")
	public String profile(HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		if (user.getRoleId() == 1) {
			return "AdminProfile";

		} else if (user.getRoleId() == 2) {
			return "ManagerProfile";

		} else {
			return "UserProfile";

		}

	}

}
