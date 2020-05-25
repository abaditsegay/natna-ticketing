package com.natnasolutions.ticketing.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "owner")
@EntityListeners(AuditingEntityListener.class)
public class EventOwner extends BaseEntity<String> implements Serializable {

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
	private List<Event> events;

}
