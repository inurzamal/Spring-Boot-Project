package com.nur.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nur.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
