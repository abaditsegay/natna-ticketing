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

import com.natnasolutions.ticketing.model.Ticket;
import com.natnasolutions.ticketing.service.TicketService;
import com.natnasolutions.ticketing.util.EnConstants;
import com.natnasolutions.ticketing.util.ResponseDetails;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/ticket")
	public ResponseDetails getAllTickets() {
		List<Ticket> tickets = ticketService.getAllTickets();
		if (tickets.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, tickets);
		}

	}

	@PostMapping("/ticket")
	public ResponseDetails createTicket(@RequestBody Ticket ticket) {
		boolean response = ticketService.registerTicket(ticket);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping("/ticket")
	public ResponseDetails updateTicket(@RequestBody Ticket ticket) {
		boolean response = ticketService.registerTicket(ticket);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@GetMapping("/ticket/event/{id}")
	public ResponseDetails getTicketsByType(@PathVariable("ticketType") String ticketType) {
		List<Ticket> tickets = ticketService.getTicketsByType(ticketType);
		if (tickets.isEmpty()) {
			return new ResponseDetails(EnConstants.RECORD_NOT_FOUND_CODE, EnConstants.RECORD_NOT_FOUND_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, tickets);
		}
	}

	@GetMapping("/tickets/{ticketType}/{city}/{date}/{searchText}")
	public ResponseEntity<List<Ticket>> serachTickets(@PathVariable("city") String city,
			@PathVariable("date") Date date) {
		List<Ticket> sports = ticketService.searchSports(city, date);
		return new ResponseEntity<List<Ticket>>(sports, HttpStatus.OK);
	}

}
