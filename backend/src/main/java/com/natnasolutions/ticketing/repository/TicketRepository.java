package com.natnasolutions.ticketing.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "SELECT * FROM Ticket WHERE ticket_type = :ticketType", nativeQuery = true)
	public List<Ticket> getTicketsByType(@Param("ticketType") String ticketType);

	@Query(value = "SELECT * FROM Ticket WHERE ticket_type = sport AND city=:city AND ticket_date=:date ", nativeQuery = true)
	public List<Ticket> searchSports(@Param("city") String city, @Param("date") Date date);

	@Query(value = "SELECT * FROM Ticket WHERE ticket_type = concert AND city=:city AND ticket_date=:date ", nativeQuery = true)
	public List<Ticket> searchConcerts(@Param("city") String city, @Param("date") Date date);

	@Query(value = "SELECT * FROM Ticket WHERE ticket_type = theater AND city=:city AND ticket_date=:date ", nativeQuery = true)
	public List<Ticket> searchTheaters(@Param("city") String city, @Param("date") Date date);
}
