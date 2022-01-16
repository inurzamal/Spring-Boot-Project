package com.nur.location.service;

import java.util.List;

import com.nur.location.entities.Location;

public interface LocationService {
	
	Location saveLocation(Location location);
	
	Location updateLocation(Location location);
	
	void deleteLocation(Location location);
	
	void deleteLocationById(int id);
	
	Location getLocationById(int id);	
	
	List<Location> getAllLocations();

}
