package com.nur.flightcheckin.integration;

import com.nur.flightcheckin.integration.dto.Reservation;
import com.nur.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);
	
}
