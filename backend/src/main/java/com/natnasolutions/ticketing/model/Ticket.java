package com.natnasolutions.ticketing.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="ticket")
public class Ticket implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private TicketCategory ticketCategory;
//	private User userId;
	private long ticketNumber;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time")
	private Date createdTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time")
	private Date updatedTime;
	
	@ManyToOne
	@JoinColumn(name="event_Id")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name="associate_Id")
	private Associate associate;

}
