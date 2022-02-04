package com.nur.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nur.flightcheckin.integration.ReservationRestClient;
import com.nur.flightcheckin.integration.dto.Reservation;
import com.nur.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {
	
	@Autowired
	ReservationRestClient restClient;
	
	@RequestMapping("/")
	public String checkInHome() {
		return "index";
	}
	
	@GetMapping("/startCheckin")
	public String showCheckInPage() {
		return "checkInPage";		
	}
	
	@PostMapping("/processCheckIn")
	public String startCheckinHandler(@RequestParam("reservationId") Long rid, Model m) {
		Reservation reservation = restClient.findReservation(rid);
		m.addAttribute("reservation", reservation);
		return "displayReservationDetails";
		
	}
	
	@PostMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long rid, @RequestParam("numberOfBags")int numberdOfBags) {
		
		restClient.updateReservation(new ReservationUpdateRequest(rid,true,numberdOfBags));
		
		return "CheckInConfirmation";
		
	}

}
