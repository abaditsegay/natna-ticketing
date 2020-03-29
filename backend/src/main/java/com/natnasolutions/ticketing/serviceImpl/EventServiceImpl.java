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
	public List<Event> getEvents() {
		return eventRepository.findAll();
	}

	@Override
	public List<Event> getEventGroups(String eventType) {
		return eventRepository.getCustomEvents(eventType);
	}

	@Override
	public Event registerEvent(Event event) {
		return eventRepository.save(event);
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
