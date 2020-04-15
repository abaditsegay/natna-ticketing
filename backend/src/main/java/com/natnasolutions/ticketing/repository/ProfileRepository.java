package com.natnasolutions.ticketing.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

	@Modifying
	@Query(value = "UPDATE profile SET email = :email WHERE id = :id", nativeQuery = true)
	public int updateProfileByEmail(@Param("email") String email, @Param("id") Long id);

	@Modifying
	@Query(value = "UPDATE profile SET phonenumber = :phonenumber WHERE id = :id", nativeQuery = true)
	public int updateProfileByPhonenumber(@Param("phonenumber") String phonenumber, @Param("id") Long id);

	@Modifying
	@Query(value = "UPDATE profile SET firstname = :firstname, lastname = :lastname  WHERE id = :id", nativeQuery = true)
	public int updateProfileByName(@Param("firstname") String firstname, @Param("lastname") String lastname,
			@Param("id") Long id);

	@Modifying
	@Query(value = "UPDATE profile SET region = :region, city = :city  WHERE id = :id", nativeQuery = true)
	public int updateProfileByLocation(@Param("region") String region, @Param("city") String city,
			@Param("id") Long id);
}
