package com.natnasolutions.ticketing.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "ticketCategory")
@EntityListeners(AuditingEntityListener.class)
public class TicketCategory extends BaseEntity<String> implements Serializable {

	@ManyToOne
	@JoinColumn(name = "event_Id")
	private Event event;
	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "total_seats")
	private long totalSeats;

	private long price;

}
