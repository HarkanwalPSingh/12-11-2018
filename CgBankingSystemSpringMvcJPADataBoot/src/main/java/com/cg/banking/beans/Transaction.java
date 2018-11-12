package com.cg.banking.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="transaction_seq")
	@SequenceGenerator(name="transaction_seq", sequenceName="transaction_seq", initialValue=100)
	private int transactionId;
	private float amount;
	private String transactionType;
	@ManyToOne
	private Account account;
	
	public Transaction() {}

	public Transaction(float amount, String transactionType,
			Account account) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount="
				+ amount + ", transactionType=" + transactionType + "]";
	}

	
	
	
	
}
