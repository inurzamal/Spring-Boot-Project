package com.nur.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nur.flightreservation.entities.Flight;
import com.nur.flightreservation.repos.FlightRepository;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository; 
	
	@RequestMapping("/showCompleteReservation")
	public String completeReservationHandler(@RequestParam("flightId") Long flightId, Model model) {
		
		Flight flight = flightRepository.findById(flightId).get();
		model.addAttribute("flight", flight);
		
		return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservationHandler() {
		return null;
		
	}

}
