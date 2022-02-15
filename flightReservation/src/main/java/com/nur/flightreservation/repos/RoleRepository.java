package com.nur.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nur.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
