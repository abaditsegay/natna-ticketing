package com.natnasolutions.ticketing.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "Profile")
@EntityListeners(AuditingEntityListener.class)
public class Profile extends BaseEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String email;
	private String phonenumber;
	private String city;
	private String region;

}
