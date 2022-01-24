package com.nur.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nur.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
