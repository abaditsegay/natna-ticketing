package com.natnasolutions.ticketing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "userProfile")
@EntityListeners(AuditingEntityListener.class)
public class UserProfile extends BaseEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String type;
	private String address;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String image;
	private boolean status;

}
