package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.Services.MailerService;
import com.grownited.entity.RoleEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.RoleRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class SessionController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	MailerService mailerService;
	
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping("/")
	public String Login() {
		return "Login"; // jsp name
	}

	@GetMapping("/signup")
	public String signup(RoleEntity role,Model model) {
		
		List<RoleEntity> Rolelists = roleRepo.findAll();
		model.addAttribute("roles",Rolelists);
		
		
		return "Signup";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/signup")
	public String saveUser(UserEntity user, Model model) {
	
		if (!user.getPassword().equals(user.getConfirmpassword())) {
			model.addAttribute("passwordError", "Password and confirm passowerd must be same");
			return "Signup";
		}

		// developer
		// encrypted Password logic start
		// read plain text password
		String plainPassword = user.getPassword();

		// encrypt plain text password

		String encPassword = passwordEncoder.encode(plainPassword); // Bcrypt

		// user -> Password -> set -> encPassword
		user.setPassword(encPassword);

		userRepo.save(user);
		
		
		mailerService.sendMailForWelCome(user.getEmail());

		return "redirect:/login";
	}

	@PostMapping("/authenticate")
	public String authenticate(UserEntity user, Model model,HttpSession session) {
		UserEntity loggedInUser = userRepo.findByEmail(user.getEmail());
		System.out.println(loggedInUser);

		if (loggedInUser == null) {
			// credentials wrong
			model.addAttribute("error", "Invalid Credentials");
			return "Login";
		} else {

			session.setAttribute("user", loggedInUser);
			session.setMaxInactiveInterval(180);
			
			boolean answer = passwordEncoder.matches(user.getPassword(), loggedInUser.getPassword());
			if (answer == false) {
				model.addAttribute("error", "Invalid Credentials");
				return "Login";
			} else if (loggedInUser.getRoleId() == 1) {
				// Admin
				return "redirect:/admindashboard";
			} else if (loggedInUser.getRoleId() == 2) {
				// Project Manager
				return "ProjectManagerDashBoard";
			} else if (loggedInUser.getRoleId() == 3) {
				// Developer
				return "DeveloperDashBoard";
			} else {
				return "Login";
			}
		}
	}

	@GetMapping("/forgetPassword")
	public String forgetPassword() {
		return "ForgetPassword";
	}

	@PostMapping("/sendotpforrecoverpassword")
	public String sendotpforrecoverpassword(UserEntity user) {

		UserEntity dbUser = userRepo.findByEmail(user.getEmail());

		if (dbUser != null) {
			// Generate
			int otp = (int) (Math.random() * 1000000);

			// send otp on mail

			System.out.println("otp => " + otp);
			
			
			mailerService.sendMailForOTP(user.getEmail(), otp);
			

			// set otp to user account
			dbUser.setOtp(otp);

			userRepo.save(dbUser); // UserID
		}

		return "UpdatePassword";
	}

	@PostMapping("/updatepassword")
	public String updatepassword(UserEntity user, Model model) {
		if (!user.getPassword().equals(user.getConfirmpassword())) {
			model.addAttribute("passwordError", "Password and Re-type Password must be same");
			return "UpdatePassword";
		} else {
			UserEntity dbUser = userRepo.findByEmail(user.getEmail());
			
			
			if (dbUser == null || user.getOtp() == -1 || dbUser.getOtp().intValue() != user.getOtp().intValue()) {
				// Error invalid otp or email
				model.addAttribute("error", "Invalid OTP and Email");
				return "UpdatePassword";
			} else {
				// correct otp email

				String PlainPassword = user.getPassword();

				String encPassword = passwordEncoder.encode(PlainPassword);
				       dbUser.setPassword(encPassword);
				       dbUser.setOtp(-1);
				       userRepo.save(dbUser);
				       model.addAttribute("msg", "Password Update Successfully");
			}

		}

		return "Login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // Destroy s
		return "redirect:/login";
	}

}
