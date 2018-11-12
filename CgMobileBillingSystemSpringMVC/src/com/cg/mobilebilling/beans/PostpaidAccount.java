package com.cg.mobilebilling.beans;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PostpaidAccount {
	@Id
	private long mobileNo;
	@OneToOne
	private Plan plan;
	@OneToMany(mappedBy = "postPaidAccount",fetch=FetchType.EAGER)
	@MapKey
	private Map<Integer, Bill> bills;
	@ManyToOne
	@JoinColumn(name="customerID")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PostpaidAccount() {
	}

	public PostpaidAccount(long mobileNo, Plan plan, Customer customer) {
		super();
		this.mobileNo = mobileNo;
		this.plan = plan;
		this.customer = customer;
	}

	public PostpaidAccount(Plan plan) {
		super();
		this.plan = plan;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Map<Integer, Bill> getBills() {
		return bills;
	}

	public void setBills(Map<Integer, Bill> bills) {
		this.bills = bills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bills == null) ? 0 : bills.hashCode());
		result = prime * result + (int) (mobileNo ^ (mobileNo >>> 32));
		result = prime * result + ((plan == null) ? 0 : plan.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostpaidAccount other = (PostpaidAccount) obj;
		if (bills == null) {
			if (other.bills != null)
				return false;
		} else if (!bills.equals(other.bills))
			return false;
		if (mobileNo != other.mobileNo)
			return false;
		if (plan == null) {
			if (other.plan != null)
				return false;
		} else if (!plan.equals(other.plan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostpaidAccount [mobileNo=" + mobileNo + ", plan=" + plan + ", bills=" + bills + "]";
	}

}