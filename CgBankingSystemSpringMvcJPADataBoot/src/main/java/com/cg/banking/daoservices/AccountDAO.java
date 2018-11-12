package com.cg.banking.daoservices;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;

public interface AccountDAO extends JpaRepository<Account, Long>{
	/*Account save(Account account);
	Account findOne(long accountNo);
	ArrayList<Account> findAll();
	public boolean update(Account account);*/
	/*@Query
	ArrayList<Account> findFew(float balance){
		
	}*/
}