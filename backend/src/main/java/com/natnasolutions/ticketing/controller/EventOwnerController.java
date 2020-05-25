package com.natnasolutions.ticketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.EventOwner;
import com.natnasolutions.ticketing.service.EventOwnerService;

@RestController
public class EventOwnerController {
	
	@Autowired
	private EventOwnerService eventOwnerService;
	
	@PostMapping("/eventOwner/register")
	public EventOwner registerEventOwner(EventOwner eventOwner) {
		return eventOwnerService.registerEventOwner(eventOwner);
	}
	
	@GetMapping("/eventOwners")
	public ResponseEntity<List<EventOwner>> getEventOwners(){
		List<EventOwner> eventOwners = eventOwnerService.getAllEventOwners(); 
		return new ResponseEntity<List<EventOwner>>(eventOwners, HttpStatus.OK);
	}

	@GetMapping("/eventOwners/{businessName}/{ownerName}")
	public ResponseEntity<EventOwner> reviewEventOwner(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		EventOwner eventOwner = eventOwnerService.getEventOwner(businessName, ownerName);
		return new ResponseEntity<EventOwner>(eventOwner, HttpStatus.OK);
	}
	
	@PutMapping("/eventOwner/approval/{businessName}/{ownerName}")
	public void approveEventOwner(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		eventOwnerService.approveEventOwner(businessName, ownerName);
	}
	
	@PutMapping("/eventOwner/rejection/{businessName}/{ownerName}")
	public void rejectEventOwner(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		eventOwnerService.rejectEventOwner(businessName, ownerName);
	}
	
	@PutMapping("/eventOwner/enable/{businessName}/{ownerName}")
	public void enableEventOwner(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		eventOwnerService.enableEventOwner(businessName, ownerName);
	}
	
	@PutMapping("/eventOwner/disable/{businessName}/{ownerName}")
	public void disableEventOwner(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		eventOwnerService.disableEventOwner(businessName, ownerName);
	}
	
}
