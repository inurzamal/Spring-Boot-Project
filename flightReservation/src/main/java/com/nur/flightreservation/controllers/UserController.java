package com.nur.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nur.flightreservation.entities.User;
import com.nur.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String showHome() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@PostMapping("/login1")
	public String registrationHandler(@ModelAttribute("user") User user) {
		
		userRepository.save(user);
		return "login/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@PostMapping("/findflights")
	public String loginHandler(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		User user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password)) {
			return "findFlights";
		}else {
			model.addAttribute("msg", "Inavalid Email or Password");
		}
		return "login/login";
	}
	
}
