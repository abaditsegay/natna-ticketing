package com.natnasolutions.ticketing.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping("/events")
	public ResponseEntity<List<Event>> getEvents() {
		List<Event> events = eventService.getEvents();

		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}

	@GetMapping("/events/{eventType}")
	public ResponseEntity<List<Event>> getEventGroups(@PathVariable("eventType") String eventType) {
		List<Event> events = eventService.getEventGroups(eventType);
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}

	
	@PostMapping("/event/register")
	public ResponseEntity<Event> registerEvent(@RequestBody Event event) {
		Event eventSaved = eventService.registerEvent(event);
		return new ResponseEntity<Event>(eventSaved, HttpStatus.OK);
	}
	
	@GetMapping("/events/sports/{city}/{date}")
	public ResponseEntity<List<Event>> serachSports(@PathVariable("city") String city, @PathVariable("date") Date date){
		List<Event> sports = eventService.searchSports(city,date);
		return new ResponseEntity<List<Event>>(sports,HttpStatus.OK);
	}
	
	@GetMapping("/events/concerts/{city}/{date}")
	public ResponseEntity<List<Event>> serachConcerts(@PathVariable("city") String city, @PathVariable("date") Date date){
		List<Event> concerts = eventService.searchConcerts(city,date);
		return new ResponseEntity<List<Event>>(concerts,HttpStatus.OK);
	}
	
	@GetMapping("/events/theaters/{city}/{date}")
	public ResponseEntity<List<Event>> serachTheaters(@PathVariable("city") String city, @PathVariable("date") Date date){
		List<Event> theathers = eventService.searchTheaters(city, date);
		return new ResponseEntity<List<Event>>(theathers,HttpStatus.OK);
	}
}
