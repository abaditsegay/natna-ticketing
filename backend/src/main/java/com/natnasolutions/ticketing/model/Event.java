package com.natnasolutions.ticketing.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "event")
@EntityListeners(AuditingEntityListener.class)
public class Event extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_description")
	private String eventDesc;

	@Column(name = "event_type")
	private String eventType;

	@Temporal(TemporalType.DATE)
	@Column(name = "event_date")
	private Date eventDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "start_time")
	private Date startTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "end_time")
	private Date endTime;

	private String region;
	private String city;
	private String address;
	@Column(name = "image_path")
	private String imageIcon;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	@JsonIgnore
	private List<TicketCategory> categories;

	private long ticketCateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ticket_open_date")
	private Date ticketOpenDate;

	private String eventStatus;

	@ManyToOne
	@JoinColumn(name = "owner_Id")
	@JsonIgnore
	private Owner owner;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	@JsonIgnore
	private List<Ticket> tickets;

}
