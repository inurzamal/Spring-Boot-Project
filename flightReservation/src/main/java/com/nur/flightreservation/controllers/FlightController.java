package com.nur.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nur.flightreservation.entities.Flight;
import com.nur.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@PostMapping("/searchflight")
	public String searchflightHandler(@RequestParam("from") String from, @RequestParam("to") String to, 
			@RequestParam("departureDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date departureDate, Model model) {
		
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		
		model.addAttribute("flights", flights);
		
		return "displayFlights";
		
	}

}
