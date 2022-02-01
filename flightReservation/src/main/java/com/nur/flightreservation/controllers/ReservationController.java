package com.nur.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nur.flightreservation.dto.ReservationRequest;
import com.nur.flightreservation.entities.Flight;
import com.nur.flightreservation.entities.Reservation;
import com.nur.flightreservation.repos.FlightRepository;
import com.nur.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository; 
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String completeReservationHandler(@RequestParam("flightId") Long flightId, Model model) {
		
		Flight flight = flightRepository.findById(flightId).get();
		model.addAttribute("flight", flight);
		
		return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservationHandler(ReservationRequest request, Model model) {
		
		Reservation reservation = reservationService.bookFlight(request);
		
		model.addAttribute("msg", "Reservation created successfully with id "+reservation.getId());
		
		return "reservationConfirmation";
		
	}

}
