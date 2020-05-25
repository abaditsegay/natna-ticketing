package com.natnasolutions.ticketing.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "bankaccount")
@EntityListeners(AuditingEntityListener.class)
public class BankAccount extends BaseEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fullName;

	private String bank;

	private String branch;

	private String accountNumber;

	@Transient
	private String confirmAccountNumber;

	private boolean status;

}
