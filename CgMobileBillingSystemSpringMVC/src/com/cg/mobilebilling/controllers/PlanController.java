package com.cg.mobilebilling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class PlanController {
	@Autowired
	private BillingServices billingServices;
	private List<Plan> plans;
	private Plan plan;
	@RequestMapping("/getplanDetails")
	public ModelAndView getPlanDetailsAction() throws BillingServicesDownException {
		plans =billingServices.getPlanAllDetails();
		return new ModelAndView("/allPlanDetailsPage", "plans",plans);
	}
	@RequestMapping("/getPostPaidAccountPlanDetails")
	public ModelAndView getPostPaidAccountPlanDetailsAction(@RequestParam("customerID") int customerID,@RequestParam("mobileNo") long mobileNo ) throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException, PlanDetailsNotFoundException {
		plan=billingServices.getCustomerPostPaidAccountPlanDetails(customerID, mobileNo);
		return new ModelAndView("/postpaidAccountPlanDetails", "plan", plan);
	}
}
