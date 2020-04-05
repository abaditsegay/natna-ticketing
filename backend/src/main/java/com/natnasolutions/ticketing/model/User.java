package com.natnasolutions.ticketing.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "User")
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Transient
	private String role;

	@Transient
	private String passwordConfirm;

	@Transient
	private String passwordOld;

	@Column(name = "enabled", nullable = false)
	private boolean enabled = true;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "UserAndRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	@JsonIgnore
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<SubUser> subUsers = new ArrayList<>();

	/*
	 * public void addSubUser(SubUser subUser) { subUsers.add(subUser);
	 * subUser.setUser(this); }
	 * 
	 * public void removeSubUser(SubUser subUser) { subUsers.remove(subUser);
	 * subUser.setUser(this); }
	 */

	public void addRole(Role role) {
		roles.add(role);
		role.getUsers().add(this);
	}

	public void removeRole(Role role) {
		roles.remove(role);
		role.getUsers().remove(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}
		return id != null && id.equals(((User) o).getId());
	}

	@Override
	public int hashCode() {
		return 31;
	}

}
