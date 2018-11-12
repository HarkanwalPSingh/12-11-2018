package com.cg.banking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;

@Controller
public class URIController {
	
	Account account;
	Transaction transaction;
	@RequestMapping("/")
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping("/openAccount")
	public String getOpenAccountPage() {
		return "openAccountPage";
	}
	@RequestMapping("/deposit")
	public String getDepositPage() {
		return "depositPage";
	}
	@RequestMapping("/withdraw")
	public String getWithdrawPage() {
		return "withdrawPage";
	}
	@RequestMapping("/transfer")
	public String getTransferPage() {
		return "transferPage";
	}
	@RequestMapping("/transaction")
	public String getTransactionPage() {
		return "transactionPage";
	}
	@RequestMapping("/account")
	public String getAccountDetailsPage() {
		return "accountDetailsPage";
	}
	@RequestMapping("/banking")
	public String getHomePage() {
		return "indexPage";
	}
	@ModelAttribute
	public Account getAccount() {
		account = new Account();
		return account;
	}
	@ModelAttribute
	public Transaction getTransaction() {
		transaction = new Transaction();
		return transaction;
	}
}
