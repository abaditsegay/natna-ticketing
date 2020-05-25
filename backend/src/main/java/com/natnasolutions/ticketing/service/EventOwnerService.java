package com.natnasolutions.ticketing.service;

import java.util.List;

import com.natnasolutions.ticketing.model.EventOwner;

public interface EventOwnerService {

	public EventOwner registerEventOwner(EventOwner associate);

	public List<EventOwner> getAllEventOwners();

	public EventOwner getEventOwner(String businessName, String ownerName);

	public void approveEventOwner(String businessName, String ownerName);

	public void rejectEventOwner(String businessName, String ownerName);

	public void enableEventOwner(String businessName, String ownerName);

	public void disableEventOwner(String businessName, String ownerName);
}
