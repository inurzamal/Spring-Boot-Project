package com.nur.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nur.location.entities.Location;
import com.nur.location.service.LocationService;
import com.nur.location.util.EmailUtil;

@Controller
public class LocationController {
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	LocationService service;
	
	@GetMapping("/locationCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@PostMapping("/saveLoc")
	public String saveLocationHandler(@ModelAttribute("location") Location location, Model model) {
		
		Location savedLocation = service.saveLocation(location);		
		String msg = "Location saved with id: " + savedLocation.getId();		
		model.addAttribute("message", msg);	
		emailUtil.sendMail("nur.nielit18@gmail.com", "Location Saved", "This mail is sent by Spring Boot App");
		return "createLocation";
	}
	
	@GetMapping("/displayLocations")
	public String displayLocationHandler(Model model) {
		
		List<Location> allLocations = service.getAllLocations();
		model.addAttribute("list", allLocations);		
		return "displayLocations";
	}
	
	@GetMapping("/deleteLocation")
	public String deleteLocationHandler(@RequestParam("id") int id, Model model) {
		
		service.deleteLocationById(id);		
		List<Location> allLocations = service.getAllLocations();
		model.addAttribute("list", allLocations);	
		return "displayLocations";			
	}
	
	@GetMapping("/editLocation")
	public String showEdit(@RequestParam("id") int id, Model model) {
		Location location = service.getLocationById(id);
		model.addAttribute("location", location);
		return "editLocation";		
	}
	
	@PostMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, Model model) {		
		service.updateLocation(location);	
		List<Location> allLocations = service.getAllLocations();
		model.addAttribute("list", allLocations);	
		return "displayLocations";			
	}
}
