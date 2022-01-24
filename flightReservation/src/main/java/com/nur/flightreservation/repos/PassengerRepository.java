package com.nur.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nur.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
