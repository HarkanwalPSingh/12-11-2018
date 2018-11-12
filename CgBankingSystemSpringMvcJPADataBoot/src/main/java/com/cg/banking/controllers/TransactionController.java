package com.cg.banking.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;



@Controller
public class TransactionController {
	@Autowired
	private BankingServices bankingServices;
	
	@RequestMapping("/transactions")
	public ModelAndView viewTransactionsAction(@RequestParam("accountNumber") String accountNumber,@RequestParam("pinNumber") String pinNumber) throws NumberFormatException, InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		List<Transaction> transactions = bankingServices.getAccountAllTransaction(Long.parseLong(accountNumber));
		return new ModelAndView("transactionDetailsPage", "transactions", transactions);
	}
	
}
