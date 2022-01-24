package com.nur.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nur.flightreservation.entities.User;
import com.nur.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/register")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@PostMapping("/registration")
	public String registrationHandler(@ModelAttribute("user") User user) {
		
		userRepository.save(user);
		return "login/login";
	}

}
