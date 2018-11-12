package com.cg.banking.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;

public interface TransactionDAO extends JpaRepository<Transaction, Integer>{
}
