package com.cg.banking.beans;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Account {
	private int pinNumber;
	@NotEmpty
	private String accountType;
	private String status;
	@NotNull
	private float accountBalance;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_account")
	@SequenceGenerator(name="seq_account",sequenceName="seq_account",initialValue=123123123,allocationSize=1)
	private long accountNo;	
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="account")
	private List<Transaction> transaction;
	
/*	@Embedded
	private Address address;*/
	public Account() {
		super();
	}

	/**
	 * @param pinNumber
	 * @param accountType
	 * @param status
	 * @param accountBalance
	 * @param accountNo
	 * @param address
	 * @param customer
	 * @param transaction
	 */
	
	public Account(int pinNumber, String accountType, String status,
			float accountBalance) {
		super();
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		
	}

	public Account(String accountType, float accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

/*	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}*/

	

	/**
	 * 
	 */
	

	@Override
	public String toString() {
		return "Account [pinNumber=" + pinNumber + ", accountType="
				+ accountType + ", status=" + status + ", accountBalance="
				+ accountBalance + ", accountNo=" + accountNo + ", customer=" + "]";
	}
	
	
	
	
	
	}
