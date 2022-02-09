package com.nur.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nur.flightreservation.dto.ReservationUpdateRequest;
import com.nur.flightreservation.entities.Reservation;
import com.nur.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@GetMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		
		LOGGER.info("Inside findReservation() of ReservationRestController for id "+id);
		
		return reservationRepository.findById(id).get();		
	}
	
	@PostMapping("/updateReservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		LOGGER.info("Inside updateReservation() of ReservationRestController for "+request);
		
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		
		LOGGER.info("Saving Reservation inside updateReservation() of ReservationRestController");
		return reservationRepository.save(reservation);		
	}
}
