package com.natnasolutions.ticketing.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.model.BankAccount;
import com.natnasolutions.ticketing.repository.EventRepository;
import com.natnasolutions.ticketing.repository.BankAccountRepository;
import com.natnasolutions.ticketing.service.EventService;
import com.natnasolutions.ticketing.service.BankAccountService;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	public List<BankAccount> getAllBankAccounts() {
		return bankAccountRepository.findAll();
	}

	public boolean createBankAccount(BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount) != null;
	}

	public boolean updateBankAccount(BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount) != null;
	}

	public boolean updateBankAccountByAccountNumber(BankAccount bankAccount) {
		// getting bankAccount ID for the logged user
		int response = bankAccountRepository.updateBankAccountByAccountNumber(bankAccount.getAccountNumber(),
				bankAccount.getId());
		if (response > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean enableBankAccount(BankAccount bankAccount) {
		// getting bankAccount ID for the logged user
		int response = bankAccountRepository.enableBankAccount(bankAccount.isStatus(), bankAccount.getId());
		if (response > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean disableBankAccount(BankAccount bankAccount) {
		// getting bankAccount ID for the logged user
		int response = bankAccountRepository.disableBankAccount(bankAccount.isStatus(), bankAccount.getId());
		if (response > 0) {
			return true;
		} else {
			return false;
		}
	}

}
