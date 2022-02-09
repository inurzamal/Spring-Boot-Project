package com.nur.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservationHandler(@RequestParam("flightId") Long flightId, Model model) {		
		LOGGER.info("Inside showCompleteReservationHandler() method of ReservationController class. Flight id: "+flightId );		
		Flight flight = flightRepository.findById(flightId).get();
		model.addAttribute("flight", flight);
		LOGGER.info("Flight is: "+flight);
		return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservationHandler(ReservationRequest request, Model model) {
		
		LOGGER.info("completeReservationHandler() "+ request);
		
		Reservation reservation = reservationService.bookFlight(request);
		
		model.addAttribute("msg", "Reservation created successfully with id "+reservation.getId());
		
		return "reservationConfirmation";
		
	}

}
