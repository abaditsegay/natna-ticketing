package com.natnasolutions.ticketing.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.service.EventService;
import com.natnasolutions.ticketing.util.EnConstants;
import com.natnasolutions.ticketing.util.ResponseDetails;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping("/event")
	public ResponseDetails getAllEvents() {
		List<Event> events = eventService.getAllEvents();
		if (events.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, events);
		}

	}

	@GetMapping("/event/{eventType}")
	public ResponseDetails getEventsByType(@PathVariable("eventType") String eventType) {
		List<Event> events = eventService.getEventsByType(eventType);
		if (events.isEmpty()) {
			return new ResponseDetails(EnConstants.RECORD_NOT_FOUND_CODE, EnConstants.RECORD_NOT_FOUND_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, events);
		}
	}

	@PostMapping("/event")
	public ResponseDetails createEvent(@RequestBody Event event) {
		boolean response = eventService.registerEvent(event);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping("/event")
	public ResponseDetails updateEvent(@RequestBody Event event) {
		boolean response = eventService.registerEvent(event);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@GetMapping("/events/{eventType}/{city}/{date}/{searchText}")
	public ResponseEntity<List<Event>> serachEvents(@PathVariable("city") String city,
			@PathVariable("date") Date date) {
		List<Event> sports = eventService.searchSports(city, date);
		return new ResponseEntity<List<Event>>(sports, HttpStatus.OK);
	}

}
