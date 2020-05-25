package com.natnasolutions.ticketing.service;

import java.util.Date;
import java.util.List;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.model.Ticket;

public interface TicketService {

	public boolean registerEvent(Ticket ticket);

	public List<Ticket> getAllTickets();

	public List<Ticket> getTicketsByType(String ticketType);

	public List<Ticket> searchSports(String city, Date date);

	public List<Ticket> searchConcerts(String city, Date date);

	public List<Ticket> searchTheaters(String city, Date date);

	public boolean registerTicket(Ticket ticket);

}
