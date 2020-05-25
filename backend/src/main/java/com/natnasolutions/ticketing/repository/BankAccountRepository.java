package com.natnasolutions.ticketing.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	@Modifying
	@Query(value = "UPDATE bankaccount SET bankaccount = :bankaccount WHERE id = :id", nativeQuery = true)
	public int updateBankAccountByAccountNumber(@Param("bankaccount") String bankaccount, @Param("id") Long id);

	@Modifying
	@Query(value = "UPDATE bankaccount SET status = :status WHERE id = :id", nativeQuery = true)
	public int enableBankAccount(@Param("status") boolean status, @Param("id") Long id);

	@Modifying
	@Query(value = "UPDATE bankaccount SET status = :status WHERE id = :id", nativeQuery = true)
	public int disableBankAccount(@Param("status") boolean status, @Param("id") Long id);

}
