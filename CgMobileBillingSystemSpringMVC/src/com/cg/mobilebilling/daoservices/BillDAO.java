package com.cg.mobilebilling.daoservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.mobilebilling.beans.Bill;

public interface BillDAO extends JpaRepository<Bill, Integer> {
	/*@Query("select a.bills from PostpaidAccount a where a.mobileNo =:mobileNo and a.bills.billMonth =:billMonth")
	Bill getMonthlyBill(@Param("mobileNo") long mobileNo,@Param("billMonth") String billMonth);*/
	@Query("select a.bills from PostpaidAccount a where a.mobileNo =:mobileNo")
	List<Bill> getCustomerPostPaidAccountAllBills(@Param("mobileNo") long mobileNo);
}
