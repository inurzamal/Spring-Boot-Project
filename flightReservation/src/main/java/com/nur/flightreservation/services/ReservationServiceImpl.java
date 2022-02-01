package com.nur.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nur.flightreservation.dto.ReservationRequest;
import com.nur.flightreservation.entities.Flight;
import com.nur.flightreservation.entities.Passenger;
import com.nur.flightreservation.entities.Reservation;
import com.nur.flightreservation.repos.FlightRepository;
import com.nur.flightreservation.repos.PassengerRepository;
import com.nur.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		
		//Make Payment
		//request.getCardNo();
		//After successful payment
		
		Long flightId = request.getFlightId(); //using this flightId we will retrieve FLight
		Flight flight = flightRepository.findById(flightId).get();
		
		//Now we have the Flight, we need to create a Passenger in the database
		Passenger passenger = new Passenger();
		
		passenger.setFirstName(request.getPassengerFisrtName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		
		Reservation reservation = new Reservation();
		
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
			
		
		return savedReservation;
	}

}
