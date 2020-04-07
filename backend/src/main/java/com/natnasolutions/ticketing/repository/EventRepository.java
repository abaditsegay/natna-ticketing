package com.natnasolutions.ticketing.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	@Query(value = "SELECT * FROM Event WHERE event_type = :eventType", nativeQuery = true)
	public List<Event> getEventsByType(@Param("eventType") String eventType);

	@Query(value = "SELECT * FROM Event WHERE event_type = sport AND city=:city AND event_date=:date ", nativeQuery = true)
	public List<Event> searchSports(@Param("city") String city, @Param("date") Date date);

	@Query(value = "SELECT * FROM Event WHERE event_type = concert AND city=:city AND event_date=:date ", nativeQuery = true)
	public List<Event> searchConcerts(@Param("city") String city, @Param("date") Date date);

	@Query(value = "SELECT * FROM Event WHERE event_type = theater AND city=:city AND event_date=:date ", nativeQuery = true)
	public List<Event> searchTheaters(@Param("city") String city, @Param("date") Date date);
}
