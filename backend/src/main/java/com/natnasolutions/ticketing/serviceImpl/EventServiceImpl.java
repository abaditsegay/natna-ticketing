package com.natnasolutions.ticketing.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.repository.EventRepository;
import com.natnasolutions.ticketing.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public List<Event> getEventsByType(String eventType) {
		return eventRepository.getEventsByType(eventType);
	}

	@Override
	public boolean registerEvent(Event event) {
		return eventRepository.save(event) != null;
	}

	@Override
	public List<Event> searchSports(String city, Date date) {

		return eventRepository.searchSports(city, date);
	}

	@Override
	public List<Event> searchConcerts(String city, Date date) {
		return eventRepository.searchConcerts(city, date);
	}

	@Override
	public List<Event> searchTheaters(String city, Date date) {
		return eventRepository.searchTheaters(city, date);
	}

}
