package com.cg.mobilebilling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;

@Controller
public class URIController {
	private Customer customer;
	private PostpaidAccount postpaidAccount;
	private Bill bill;
	private Plan plan;
	@RequestMapping("/")
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping("/mobilebilling")
	public String getHomePage() {
		return "indexPage";
	}
	@RequestMapping("/addCustomer")
	public String addCustomerPage() {
		return "addCustomerPage";
	}
	@RequestMapping("/addPostpaidAccount")
	public String addPostpaidAccountPage() {
		return "addPostpaidAccountPage";
	}
	@RequestMapping("/removeCustomer")
	public String removeCustomerPage() {
		return "removeCustomerPage";
	}
	@RequestMapping("/customerDetails")
	public String customerDetailsPage() {
		return "customerDetailsPage";
	}
	@RequestMapping("/postPaidAccountDetails")
	public String postPaidAccountDetailsPage() {
		return "postPaidAccountDetailsPage";
	}
	@RequestMapping("/allpostPaidAccountDetails")
	public String allpostPaidAccountDetailsPage() {
		return "allpostPaidAccountDetailsPage";
	}
	@RequestMapping("/removePostpaidAccount")
	public String removePostpaidAccountPage() {
		return "removePostpaidAccountPage";
	}
	@RequestMapping("/generateBill")
	public String generateBillPage() {
		return "generateBillPage";
	}
	@RequestMapping("/postpaidAccountBillDetails")
	public String postpaidAccountBillDetailsPage() {
		return "postpaidAccountBillDetailsPage";
	}
	@RequestMapping("/mobileBillDetails")
	public String mobileBillDetailsPage() {
		return "mobileBillDetailsPage";
	}
	@RequestMapping("/postPaidAccountPlanDetails")
	public String postPaidAccountPlanDetailsPage() {
		return "postPaidAccountPlanDetailsPage";
	}
	@ModelAttribute
	public Customer getCustomer() {
		customer = new Customer();
		return customer;
	}
	@ModelAttribute
	public PostpaidAccount getPostpaidAccount() {
		postpaidAccount = new PostpaidAccount();
		return postpaidAccount;
	}
	@ModelAttribute
	public Bill getBill() {
		bill = new Bill();
		return bill;
	}
	@ModelAttribute
	public Plan getPlan() {
		plan = new Plan();
		return plan;
	}
}
