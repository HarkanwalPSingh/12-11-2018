package com.cg.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.TransactionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

@Component(value = "bankingServices")
public class BankingServicesImpl implements BankingServices {
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	TransactionDAO transactionDAO;
	Account account;
	Account accountTo;
	Account accountFrom;
	List<Account> accountList;
	List<Transaction> transactionList;
	Transaction transaction;

	@Override
	public Account openAccount(Account account)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		account = new Account(1234, account.getAccountType(), "Active", account.getAccountBalance());
		account = accountDAO.save(account);
		return account;
	}

	@Override
	public Account depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		account = accountDAO.findById(accountNo).get();
		account.setAccountBalance(account.getAccountBalance() + amount);
		account=accountDAO.save(account);
		transaction = new Transaction(amount, "Deposit", account);
		transaction = transactionDAO.save(transaction);
		return account;
	}

	@Override
	public Account withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		account = accountDAO.findById(accountNo).get();
		if (account.getPinNumber() == 1234) {
			if ((account.getAccountBalance() - amount) < 0)
				throw new InsufficientAmountException();
			else {
				account.setAccountBalance(account.getAccountBalance() - amount);
				account=accountDAO.save(account);
				transaction = new Transaction(amount, "Withdrawal", account);
				transaction = transactionDAO.save(transaction);
			}
			return account;
		} else
			throw new InvalidPinNumberException();

	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		accountTo = accountDAO.findById(accountNoTo).get();
		accountFrom = accountDAO.findById(accountNoFrom).get();
		if (accountFrom.getPinNumber() == 1234) {
			if ((accountFrom.getAccountBalance() - transferAmount) < 0)
				throw new InsufficientAmountException();
			else {
				accountFrom.setAccountBalance(account.getAccountBalance() - transferAmount);
				accountTo.setAccountBalance(account.getAccountBalance() + transferAmount);
				accountDAO.save(accountFrom);
				transaction = new Transaction(transferAmount, "Withdrawal", account);
				transaction = transactionDAO.save(transaction);
				accountDAO.save(accountTo);
				transaction = new Transaction(transferAmount, "Deposit", account);
				transaction = transactionDAO.save(transaction);
			}
		}
		return true;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		account = accountDAO.findById(accountNo).get();
		return account;
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		accountList = accountDAO.findAll();
		return accountList;
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		transactionList = transactionDAO.findAll();
		return transactionList;
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		account = accountDAO.findById(accountNo).get();
		return account.getStatus();
	}

}
