package com.natnasolutions.ticketing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<T> {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@CreatedBy
	@Column(name = "createdBy", nullable = false, updatable = false)
	protected String createdBy;

	@Column(name = "createdDate", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	@Column(name = "updatedDate", insertable = false)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date updatedDate;

	@LastModifiedBy
	@Column(name = "updatedBy", insertable = false)
	protected String updatedBy;
}
