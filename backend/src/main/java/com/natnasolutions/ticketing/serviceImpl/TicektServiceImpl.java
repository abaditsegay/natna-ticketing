package com.natnasolutions.ticketing.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.Ticket;
import com.natnasolutions.ticketing.repository.TicketRepository;
import com.natnasolutions.ticketing.service.TicketService;

@Service
@Transactional
public class TicektServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public List<Ticket> getTicketsByType(String ticketType) {
		return ticketRepository.getTicketsByType(ticketType);
	}

	@Override
	public boolean registerTicket(Ticket ticket) {
		return ticketRepository.save(ticket) != null;
	}

	@Override
	public List<Ticket> searchSports(String city, Date date) {

		return ticketRepository.searchSports(city, date);
	}

	@Override
	public List<Ticket> searchConcerts(String city, Date date) {
		return ticketRepository.searchConcerts(city, date);
	}

	@Override
	public List<Ticket> searchTheaters(String city, Date date) {
		return ticketRepository.searchTheaters(city, date);
	}

	@Override
	public boolean registerEvent(Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}

}
