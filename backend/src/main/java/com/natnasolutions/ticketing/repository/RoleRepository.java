package com.natnasolutions.ticketing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.model.User;
import com.natnasolutions.ticketing.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query(value = "SELECT * FROM userrole WHERE roleType = :roleType", nativeQuery = true)
	public List<Role> getUserRoles(@Param("roleType") String roleType);

}
