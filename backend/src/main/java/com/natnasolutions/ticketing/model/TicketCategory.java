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
@Table(name="ticketCategory")
public class TicketCategory implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name="event_Id")
	private Event event;
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "total_seats")
	private long totalSeats;
	
	private long price;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "created_time")
	private Date createdTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "updated_time")
	private Date updatedTime;

	
}
