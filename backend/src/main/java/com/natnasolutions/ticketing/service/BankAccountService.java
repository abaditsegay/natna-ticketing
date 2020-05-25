package com.natnasolutions.ticketing.service;

import java.util.List;

import com.natnasolutions.ticketing.model.BankAccount;

public interface BankAccountService {

	public List<BankAccount> getAllBankAccounts();

	public boolean createBankAccount(BankAccount profile);

	public boolean updateBankAccount(BankAccount profile);

	public boolean updateBankAccountByAccountNumber(BankAccount email);

	public boolean enableBankAccount(BankAccount profile);

	public boolean disableBankAccount(BankAccount profile);

}
