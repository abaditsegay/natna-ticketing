package com.natnasolutions.ticketing.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Role")
@EntityListeners(AuditingEntityListener.class)
public class Role extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "RoleType is empty and please provide valid value")
	@Column(name = "roleType", nullable = false, unique = true)
	private String roleType;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<User> users = new HashSet<>();

}
