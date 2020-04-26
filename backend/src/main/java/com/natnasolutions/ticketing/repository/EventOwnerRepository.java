package com.natnasolutions.ticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.EventOwner;

@Repository
public interface EventOwnerRepository extends JpaRepository<EventOwner, Long> {

	
	@Query(value = "Select * FROM EventOwner WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public EventOwner getEventOwner(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

	
	/**
	 * A - approved
	 * R - rejected
	 * 
	 */
	@Query(value = "UPDATE EventOwner SET associate_status = A WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public void approveEventOwner(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

	/**
	 * A - approved
	 * R - rejected
	 * 
	 */
	@Query(value = "UPDATE EventOwner SET associate_status = R WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public void rejectEventOwner(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

	/**
	 * E-enabled
	 * D-disabled
	 * @param businessName
	 * @param ownerName
	 */
	@Query(value = "UPDATE EventOwner SET associate_status = E WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public void enableEventOwner(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

	/**
	 * E-enabled
	 * D-disabled
	 * @param businessName
	 * @param ownerName
	 */
	@Query(value = "UPDATE EventOwner SET associate_status = D WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public void disableEventOwner(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

}
