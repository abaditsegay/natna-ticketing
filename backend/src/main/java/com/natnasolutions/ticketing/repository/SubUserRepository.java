package com.natnasolutions.ticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.SubUser;

@Repository
public interface SubUserRepository extends JpaRepository<SubUser, Long> {
	/*
	 * public long createUserRole(UserRole userRole);
	 * 
	 * public UserRole updateUserRole(UserRole userRole);
	 * 
	 * public void deleteUserRole(long id);
	 * 
	 * public List<UserRole> getAllUserRoles();
	 * 
	 * public UserRole getUserRole(long id);
	 */

}
