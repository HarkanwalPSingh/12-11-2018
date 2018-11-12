package com.cg.mobilebilling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.exceptions.BillDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.InvalidBillMonthException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;
@Controller
public class BillController {
private Bill bill;
private List<Bill> bills;
@Autowired
private BillingServices billingServices;

@RequestMapping("generateMonthlyMobileBill")
public ModelAndView registerPostpaidAccountAction(@RequestParam("customerID") int customerID, @RequestParam("mobileNo") long mobileNo,@RequestParam("billMonth")String billMonth,@RequestParam("noOfLocalSMS")int noOfLocalSMS,@RequestParam("noOfStdSMS")int noOfStdSMS,@RequestParam("noOfLocalCalls")int noOfLocalCalls,@RequestParam("noOfStdCalls")int noOfStdCalls,@RequestParam("internetDataUsageUnits")int internetDataUsageUnits) throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException, PostpaidAccountNotFoundException, InvalidBillMonthException {
	bill = billingServices.generateMonthlyMobileBill(customerID, mobileNo, billMonth, noOfLocalSMS, noOfStdSMS, noOfLocalCalls, noOfStdCalls, internetDataUsageUnits);
	return new ModelAndView("/generateBillSuccessPage", "bill",bill);
}

@RequestMapping("getPostpaidAccountBillDetails")
public ModelAndView postpaidAccountBillDetailsAction(@RequestParam("customerID") int customerID, @RequestParam("mobileNo") long mobileNo) throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException, PostpaidAccountNotFoundException, InvalidBillMonthException, BillDetailsNotFoundException {
bills = billingServices.getCustomerPostPaidAccountAllBillDetails(customerID, mobileNo);
	return new ModelAndView("/postpaidAccountBillDetailsPage", "bills",bills);
}

@RequestMapping("getMobileBillDetails")
public ModelAndView getMobileBillDetailsAction(@RequestParam("customerID") int customerID, @RequestParam("mobileNo") long mobileNo,@RequestParam("billMonth")String billMonth) throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException, PostpaidAccountNotFoundException, InvalidBillMonthException, BillDetailsNotFoundException {
bill = billingServices.getMobileBillDetails(customerID, mobileNo, billMonth);
	return new ModelAndView("/MobileBillDetailsPage", "bill",bill);
}
}
