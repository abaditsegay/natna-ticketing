package com.natnasolutions.ticketing.service;

import java.util.Date;
import java.util.List;

import com.natnasolutions.ticketing.model.Event;

public interface EventService {
	
	public Event registerEvent(Event event);

	public List<Event> getEvents();
	
	public List<Event> getEventGroups(String eventType);

	public List<Event> searchSports(String city, Date date);
	
	public List<Event> searchConcerts(String city, Date date);
	public List<Event> searchTheaters(String city, Date date);

}
