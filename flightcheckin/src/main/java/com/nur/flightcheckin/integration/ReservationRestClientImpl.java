package com.nur.flightcheckin.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nur.flightcheckin.integration.dto.Reservation;
import com.nur.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	@Value("${com.nur.flightcheckin.reservation_rest_url}")
	private String RESERVATION_REST_URL;
	@Value("${com.nur.flightcheckin.reservation_rest_url_update}")
	private String RESERVATION_REST_URL_UPDATE;

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL_UPDATE, request, Reservation.class);
		return reservation;
	}

}
