package com.nur.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nur.flightreservation.dto.ReservationRequest;
import com.nur.flightreservation.entities.Flight;
import com.nur.flightreservation.entities.Passenger;
import com.nur.flightreservation.entities.Reservation;
import com.nur.flightreservation.repos.FlightRepository;
import com.nur.flightreservation.repos.PassengerRepository;
import com.nur.flightreservation.repos.ReservationRepository;
import com.nur.flightreservation.util.EmailUtil;
import com.nur.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
		
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookFlight() method of ReservationServiceImpl class in service layer");
				
		//Make Payment
		//request.getCardNo();
		//After successful payment
		
		Long flightId = request.getFlightId(); //using this flightId we will retrieve FLight
		LOGGER.info("Fetching flightID: "+flightId);
		Flight flight = flightRepository.findById(flightId).get();
		LOGGER.info("Found Flight using flightID: "+flight);
		
		//Now we have the Flight, we need to create a Passenger in the database
		Passenger passenger = new Passenger();
		
		passenger.setFirstName(request.getPassengerFisrtName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		LOGGER.info("Saving the passenger: " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		
		Reservation reservation = new Reservation();
		
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		LOGGER.info("Saving the reservation "+reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "C:\\Users\\User\\Documents\\reservations\\reservation"+savedReservation.getId()+".pdf";

		
		LOGGER.info("Generating Ticket - filePath: "+filePath);
		pdfGenerator.generateTicket(savedReservation, filePath);
		
		LOGGER.info("Emailing the Ticket");
		emailUtil.sendTicket(passenger.getEmail(), filePath);
				
		
		return savedReservation;
	}

}
