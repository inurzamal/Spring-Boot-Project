package com.nur.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nur.flightreservation.entities.Flight;
import com.nur.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	@PostMapping("/searchflight")
	public String searchflightHandler(@RequestParam("from") String from, @RequestParam("to") String to, 
			@RequestParam("departureDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date departureDate, Model model) {
		
		LOGGER.info("Inside searchFlightHandler() method of FlightController class "+"From: "+from+" To: "+to+"DepartureDate: "+departureDate);
		
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		
		model.addAttribute("flights", flights);
		
		LOGGER.info("Flight Founds are: "+ flights);
		
		return "displayFlights";
		
	}
	
	@GetMapping("admin/addFlight")
	public String showAddFlight() {
		return "addFlight";		
	}

}
