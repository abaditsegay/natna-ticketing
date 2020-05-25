package com.natnasolutions.ticketing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.Associate;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long> {

	@Query(value = "Select * FROM Associate WHERE id = :id ", nativeQuery = true)
	public List<Associate> getAssociateByID(@Param("id") Long id);

	@Query(value = "UPDATE Associate SET associate_approval = A WHERE id = :id", nativeQuery = true)
	public int approveAssociate(@Param("id") Long id);

	@Query(value = "UPDATE Associate SET associate_approval = R WHERE id = :id", nativeQuery = true)
	public int rejectAssociate(@Param("id") Long id);

	@Query(value = "UPDATE Associate SET associate_status = E WHERE id = :id", nativeQuery = true)
	public int enableAssociate(@Param("id") Long id);

	@Query(value = "UPDATE Associate SET associate_status = D WHERE id = :id", nativeQuery = true)
	public int disableAssociate(@Param("id") Long id);

	@Query(value = "Select * FROM Associate WHERE associate_status = :status ", nativeQuery = true)
	public List<Associate> getAssociateByStatus(@Param("status") String status);

	@Query(value = "Select * FROM Associate WHERE associate_approval = :status ", nativeQuery = true)
	public List<Associate> getAssociateByApprovalStatus(@Param("status") String status);

}
