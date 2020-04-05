package com.natnasolutions.ticketing.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "SubUser")
@EntityListeners(AuditingEntityListener.class)
public class SubUser extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = -1305947636364483475L;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "firstName", unique = true, nullable = false)
	private String firstName;

	@Column(name = "lastNmae", nullable = false)
	private String lastName;

	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SubUser)) {
			return false;
		}
		return id != null && id.equals(((SubUser) o).getId());
	}

	@Override
	public int hashCode() {
		return 31;
	}
}
