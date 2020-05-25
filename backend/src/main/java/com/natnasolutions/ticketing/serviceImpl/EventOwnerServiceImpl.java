package com.natnasolutions.ticketing.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.EventOwner;
import com.natnasolutions.ticketing.repository.EventOwnerRepository;
import com.natnasolutions.ticketing.service.EventOwnerService;

@Service
@Transactional
public class EventOwnerServiceImpl implements EventOwnerService {

	@Autowired
	private EventOwnerRepository repository;

	@Override
	public EventOwner registerEventOwner(EventOwner associate) {

		return repository.saveAndFlush(associate);
	}

	@Override
	public List<EventOwner> getAllEventOwners() {

		return repository.findAll();
	}

	@Override
	public EventOwner getEventOwner(String businessName, String ownerName) {

		return repository.getEventOwner(businessName, ownerName);
	}

	@Override
	public void approveEventOwner(String businessName, String ownerName) {

		repository.approveEventOwner(businessName, ownerName);
	}

	@Override
	public void rejectEventOwner(String businessName, String ownerName) {

		repository.rejectEventOwner(businessName, ownerName);
	}

	@Override
	public void enableEventOwner(String businessName, String ownerName) {

		repository.enableEventOwner(businessName, ownerName);
	}

	@Override
	public void disableEventOwner(String businessName, String ownerName) {

		repository.disableEventOwner(businessName, ownerName);
	}

}
