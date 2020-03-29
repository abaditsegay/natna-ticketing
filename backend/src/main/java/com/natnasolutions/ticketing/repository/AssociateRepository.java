package com.natnasolutions.ticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.Associate;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long> {

	
	@Query(value = "Select * FROM Associate WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public Associate getAssociate(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

	
	/**
	 * A - approved
	 * R - rejected
	 * 
	 */
	@Query(value = "UPDATE Associate SET associate_status = A WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public void approveAssociate(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

	/**
	 * A - approved
	 * R - rejected
	 * 
	 */
	@Query(value = "UPDATE Associate SET associate_status = R WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public void rejectAssociate(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

	/**
	 * E-enabled
	 * D-disabled
	 * @param businessName
	 * @param ownerName
	 */
	@Query(value = "UPDATE Associate SET associate_status = E WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public void enableAssociate(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

	/**
	 * E-enabled
	 * D-disabled
	 * @param businessName
	 * @param ownerName
	 */
	@Query(value = "UPDATE Associate SET associate_status = D WHERE business_name = :businessName AND owner_name=:ownerName ", nativeQuery = true)
	public void disableAssociate(@Param("businessName") String businessName, @Param("ownerName") String ownerName);

}
