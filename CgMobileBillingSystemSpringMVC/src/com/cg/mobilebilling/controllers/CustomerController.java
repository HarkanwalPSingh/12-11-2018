package com.cg.mobilebilling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.services.BillingServices;


@Controller
public class CustomerController {
	@Autowired
	private BillingServices billingServices;
	private Customer customer;
	private List<Customer> customers;
	@RequestMapping("/registerCustomer")
	public ModelAndView registerCustomerAction(@ModelAttribute("customer") Customer customer, BindingResult result) throws BillingServicesDownException {
		if(result.hasErrors())
			return new ModelAndView("/addCustomerPage");
		customer = billingServices.acceptCustomerDetails(customer);
		return new ModelAndView("/addCustomerSuccessPage", "customer", customer);
	}
	@RequestMapping("/deleteCustomer")
	public ModelAndView removeCustomerAction(@RequestParam int customerID) throws BillingServicesDownException, CustomerDetailsNotFoundException {
		billingServices.deleteCustomer(customerID);
		return new ModelAndView("/removeCustomerSuccessPage","customerID",customerID);
	}
	@RequestMapping("/getCustomerDetails")
	public ModelAndView getCustomerDetailsAction(@RequestParam int customerID) throws CustomerDetailsNotFoundException, BillingServicesDownException {
		customer=billingServices.getCustomerDetails(customerID);
		return new ModelAndView("/customerDetailsSuccessPage", "customer",customer);
	}
	@RequestMapping("/getAllCustomerDetails")
	public ModelAndView allCustomerDetailsAction() throws BillingServicesDownException {
		customers = billingServices.getAllCustomerDetails();
		return new ModelAndView("allCustomerDetailsPage", "customers",customers);
	}
	
}
