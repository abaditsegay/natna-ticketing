package com.natnasolutions.ticketing.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "ticket")
@EntityListeners(AuditingEntityListener.class)
public class Ticket extends BaseEntity<String> implements Serializable {

	private TicketCategory ticketCategory;

	private long ticketNumber;

	@ManyToOne
	@JoinColumn(name = "event_Id")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "associate_Id")
	private Associate associate;

}
