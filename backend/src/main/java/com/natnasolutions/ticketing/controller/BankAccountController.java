package com.natnasolutions.ticketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.BankAccount;
import com.natnasolutions.ticketing.service.BankAccountService;
import com.natnasolutions.ticketing.util.EnConstants;
import com.natnasolutions.ticketing.util.ResponseDetails;

@RestController
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;

	@GetMapping("/bankAccount")
	public ResponseDetails getAllBankAccounts() {
		List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
		if (bankAccounts.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, bankAccounts);
		}

	}

	@PostMapping("/bankAccount")
	public ResponseDetails createBankAccount(@RequestBody BankAccount bankAccount) {
		boolean response = bankAccountService.createBankAccount(bankAccount);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping("/bankAccount")
	public ResponseDetails updateBankAccount(@RequestBody BankAccount bankAccount) {
		boolean response = bankAccountService.updateBankAccount(bankAccount);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping("/bankAccount/accountNumber")
	public ResponseDetails updateBankAccountByAccountNumber(@RequestBody BankAccount bankAccount) {
		boolean response = bankAccountService.updateBankAccountByAccountNumber(bankAccount);
		if (!response) {
			return new ResponseDetails(EnConstants.RECORD_NOT_FOUND_CODE, EnConstants.RECORD_NOT_FOUND_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		}
	}

	@PutMapping("/bankAccount/enable")
	public ResponseDetails enableBankAccount(@RequestBody BankAccount bankAccount) {
		boolean response = bankAccountService.enableBankAccount(bankAccount);
		if (!response) {
			return new ResponseDetails(EnConstants.RECORD_NOT_FOUND_CODE, EnConstants.RECORD_NOT_FOUND_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		}
	}

	@PutMapping("/bankAccount/disable")
	public ResponseDetails disableBankAccount(@RequestBody BankAccount bankAccount) {
		boolean response = bankAccountService.disableBankAccount(bankAccount);
		if (!response) {
			return new ResponseDetails(EnConstants.RECORD_NOT_FOUND_CODE, EnConstants.RECORD_NOT_FOUND_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		}
	}

}
