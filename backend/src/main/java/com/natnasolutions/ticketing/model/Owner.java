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
@Table(name="owner")
public class Owner implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "business_name")
	private String businessName;
	@Column(name = "owner_name")
	private String ownerName;
	@Column(name = "business_phone")
	private String phoneNumber;
	@Column(name = "business_email")
	private String businessEmail;
	@Column(name = "agreement_file")
	private String agreementFile;
	@Column(name = "license")
	private String license;
	@Column(name = "business_address")
	private String businessAddress;
	private String kebelle;
	private String city;
	private String region;
	@Column(name = "owner_status")
	private String ownerStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time")
	private Date createdTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time")
	private Date updatedTime;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
	List<Event> events;

}
