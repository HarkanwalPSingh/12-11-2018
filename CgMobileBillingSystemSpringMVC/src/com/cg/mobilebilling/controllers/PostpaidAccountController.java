package com.cg.mobilebilling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class PostpaidAccountController {
	private PostpaidAccount postpaidAccount;
	private List<PostpaidAccount> postpaidAccounts;
	@Autowired
	private BillingServices billingServices;

	@RequestMapping("registerPostpaidAccount")
	public ModelAndView registerPostpaidAccountAction(@RequestParam("customerID") int customerID,
			@RequestParam("planID") int planID)
			throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException {
		postpaidAccount = billingServices.openPostpaidMobileAccount(customerID, planID);
		return new ModelAndView("/addPostpaidAccountSuccessPage", "postpaidAccount", postpaidAccount);
	}

	@RequestMapping("getPostpaidAccountDetails")
	public ModelAndView getPostpaidAccountDetailsAction(@RequestParam("customerID") int customerID,
			@RequestParam("mobileNo") long mobileNo) throws PlanDetailsNotFoundException,
			CustomerDetailsNotFoundException, BillingServicesDownException, PostpaidAccountNotFoundException {
		postpaidAccount = billingServices.getPostPaidAccountDetails(customerID, mobileNo);
		return new ModelAndView("/PostPaidAccountDetailsPage", "postpaidAccount", postpaidAccount);
	}
	@RequestMapping("closeCustomerPostpaidAccount")
	public ModelAndView closeCustomerPostpaidAccountAction(@RequestParam("customerID") int customerID,
			@RequestParam("mobileNo") long mobileNo) throws PlanDetailsNotFoundException,
			CustomerDetailsNotFoundException, BillingServicesDownException, PostpaidAccountNotFoundException {
		billingServices.closeCustomerPostPaidAccount(customerID, mobileNo);
		return new ModelAndView("/closeCustomerPostPaidAccountSuccessPage", "mobileNo", mobileNo);
	}
	@RequestMapping("getAllPostpaidAccountDetails")
	public ModelAndView getAllPostpaidAccountDetailsAction(@RequestParam("customerID") int customerID)
			throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException,
			PostpaidAccountNotFoundException {
		postpaidAccounts = billingServices.getCustomerAllPostpaidAccountsDetails(customerID);
		return new ModelAndView("/PostPaidAccountDetailsPage", "postpaidAccounts", postpaidAccounts);
	}

	@RequestMapping("changePlan")
	public ModelAndView changePlanAction(@RequestParam("customerID") int customerID,
			@RequestParam("mobileNo") long mobileNo, @RequestParam("planID") int planID)
			throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException,
			PostpaidAccountNotFoundException {
		billingServices.changePlan(customerID, mobileNo, planID);
		postpaidAccount = billingServices.getPostPaidAccountDetails(customerID, mobileNo);
		return new ModelAndView("/changePlanSuccessPage", "postpaidAccount", postpaidAccount);
	}
	
}
