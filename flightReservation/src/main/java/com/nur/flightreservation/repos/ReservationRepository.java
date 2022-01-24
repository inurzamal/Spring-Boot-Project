package com.nur.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nur.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
