package com.natnasolutions.ticketing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.SubUser;

@Repository
public interface SubUserRepository extends JpaRepository<SubUser, Long> {

	@Query(value = "SELECT * FROM subuser WHERE email = :email", nativeQuery = true)
	public List<SubUser> getSubUserByEmail(@Param("email") String email);

}
