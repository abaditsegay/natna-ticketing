package com.natnasolutions.ticketing.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="associate")
public class Associate implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "business_name")
	private String businessName;
	@Column(name = "owner_name")
	private String ownerName;
	@Column(name = "business_phone")
	private String businessPhone;
	@Column(name = "business_email")
	private String businessEmail;
	@Column(name = "agreement_file")
	private String agreementFile;
	private String license;
	@Column(name = "business_address")
	private String businessAddress;
	private String kebelle;
	private String city;
	private String region;
	@Column(name = "associate_status")
	private String associateStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time")
	private Date createdTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time")
	private Date updatedTime;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "associate")
	private List<Ticket> tickets;
	
}
