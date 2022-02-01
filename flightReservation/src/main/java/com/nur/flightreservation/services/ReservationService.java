package com.nur.flightreservation.services;

import com.nur.flightreservation.dto.ReservationRequest;
import com.nur.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
