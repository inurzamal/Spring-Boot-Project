package com.nur.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nur.flightreservation.entities.User;
import com.nur.flightreservation.repos.UserRepository;
import com.nur.flightreservation.services.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	SecurityService securityService;
	
	@GetMapping("/")
	public String showHome() {
		LOGGER.info("Inside home or Index Page");
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage() method");
		return "login/registerUser";
	}
	
	@PostMapping("/login1")
	public String registrationHandler(@ModelAttribute("user") User user) {		
		LOGGER.info("Inside registrationHandler() method" + user);	
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}
	
	@GetMapping("/login")
	public String login() {
		LOGGER.info("Inside login() method of UserController");
		return "login/login";
	}
	
	@PostMapping("/findflights")
	public String loginHandler(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		
		boolean loginResponse = securityService.login(email, password);
		
		LOGGER.info("Inside loginHandler() method and Email is: "+ email);	
			
		if(loginResponse) {
			return "findFlights";
		}else {
			model.addAttribute("msg", "Inavalid Email or Password");
		}
		return "login/login";
	}
	
}
