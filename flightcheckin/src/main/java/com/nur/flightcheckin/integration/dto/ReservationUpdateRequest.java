package com.nur.flightcheckin.integration.dto;

public class ReservationUpdateRequest {
	
	private Long id;
	private Boolean checkedIn;
	private int numberOfBags;

	
	public ReservationUpdateRequest() {
		super();
	}

	public ReservationUpdateRequest(Long id, Boolean checkedIn, int numberOfBags) {
		super();
		this.id = id;
		this.checkedIn = checkedIn;
		this.numberOfBags = numberOfBags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
}
