package com.cg.mobilebilling.services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.daoservices.BillDAO;
import com.cg.mobilebilling.daoservices.CustomerDAO;
import com.cg.mobilebilling.daoservices.PlanDAO;
import com.cg.mobilebilling.daoservices.PostPaidAccountDAO;
import com.cg.mobilebilling.exceptions.BillDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.InvalidBillMonthException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
@Component(value="billingServices")
public class BillingServicesImpl implements BillingServices {
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired	
	private BillDAO billDAO;
	@Autowired
	private PostPaidAccountDAO postPaidAccountDAO;
	@Autowired
	private PlanDAO planDAO;
	
	private PostpaidAccount postpaidAccount;
	private Plan plan;
	private Customer customer;
	private Bill bill;
	private List<Customer> customers;
	private Map<Long, PostpaidAccount> postpaidAccounts;
	private List<Bill>bills;
	private Plan plan1 = new Plan(101, 300, 50, 20, 50, 50, 2000, 1, 5, 1, 1, 1, "UP EAST", "Violet Base");
	private Plan plan2 = new Plan(102, 400, 100, 50, 50, 50, 5000, 1, 5, 1, 1, 1, "UP EAST", "Violet Entertainment");
	private Plan plan3 = new Plan(103, 500, 150, 100, 50, 50, 10000, 1, 5, 1, 1, 1, "UP EAST", "Violet Entertainment+");
	@Override
	public List<Plan> getPlanAllDetails() throws BillingServicesDownException {
		return planDAO.findAll();
	}

	@Override
	public Customer acceptCustomerDetails(Customer customer)
			throws BillingServicesDownException {
		planDAO.save(plan1);
		planDAO.save(plan2);
		planDAO.save(plan3);
		customer = customerDAO.save(customer);
		return customer;
	}

	@Override
	public PostpaidAccount openPostpaidMobileAccount(int customerID, int planID)
			throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException {
		plan = planDAO.findById(planID).get();
		customer = customerDAO.findById(customerID).get();
		long leftLimit = 9885238824L;
	    long rightLimit = 9895238824L ;
	    long generatedMobileNumber = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));//Totally wrong implementation
	    System.out.println(generatedMobileNumber);
	    postpaidAccount = new PostpaidAccount(generatedMobileNumber, plan, customer);
		postpaidAccount = postPaidAccountDAO.save(postpaidAccount);
		return postpaidAccount;
	}

	@Override
	public Bill generateMonthlyMobileBill(int customerID, long mobileNo, String billMonth, int noOfLocalSMS,
			int noOfStdSMS, int noOfLocalCalls, int noOfStdCalls, int internetDataUsageUnits)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
			BillingServicesDownException, PlanDetailsNotFoundException {
		customer = customerDAO.findById(customerID).get();
		postpaidAccount = postPaidAccountDAO.findById(mobileNo).get();
		plan = postpaidAccount.getPlan();
		bill = new Bill(noOfLocalSMS, noOfStdSMS, noOfLocalCalls, noOfStdCalls, internetDataUsageUnits, billMonth);
		bill.setLocalSMSAmount(plan.getLocalSMSRate()*(noOfLocalSMS-plan.getFreeLocalSMS()));
		bill.setStdSMSAmount(plan.getStdSMSRate()*(noOfStdSMS-plan.getFreeStdSMS()));
		bill.setLocalCallAmount(plan.getLocalCallRate()*(noOfLocalCalls-plan.getFreeLocalCalls()));
		bill.setStdCallAmount(plan.getStdCallRate()*(noOfStdCalls-plan.getFreeStdCalls()));
		bill.setInternetDataUsageAmount(plan.getInternetDataUsageRate()*(internetDataUsageUnits-plan.getFreeInternetDataUsageUnits()));
		bill.setTotalBillAmount(bill.getLocalCallAmount()+bill.getStdCallAmount()+bill.getLocalSMSAmount()+bill.getStdSMSAmount()+bill.getInternetDataUsageAmount());
		bill.setServicesTax((float) (bill.getTotalBillAmount()*0.025));
		bill.setVat((float) (bill.getTotalBillAmount()*0.025));
		bill.setTotalBillAmount(bill.getTotalBillAmount()+bill.getServicesTax()+bill.getVat());
		return bill;
	}

	@Override
	public Customer getCustomerDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		customer = customerDAO.findById(customerID).get();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws BillingServicesDownException {
		customers = customerDAO.findAll();
		return customers;
	}

	@Override
	public PostpaidAccount getPostPaidAccountDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException {
		return postPaidAccountDAO.findById(mobileNo).get();
	}

	@Override
	public List<PostpaidAccount> getCustomerAllPostpaidAccountsDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		return postPaidAccountDAO.findAll();
	}

	@Override
	public Bill getMobileBillDetails(int customerID, long mobileNo, String billMonth)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
			BillDetailsNotFoundException, BillingServicesDownException {
		//bill=billDAO.getMonthlyBill(mobileNo, billMonth);
		return bill;
	}

	@Override
	public List<Bill> getCustomerPostPaidAccountAllBillDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			BillDetailsNotFoundException {
		bills=billDAO.getCustomerPostPaidAccountAllBills(mobileNo);
		return bills;
	}

	@Override
	public boolean changePlan(int customerID, long mobileNo, int planID) throws CustomerDetailsNotFoundException,
			PostpaidAccountNotFoundException, PlanDetailsNotFoundException, BillingServicesDownException {
		postpaidAccount = postPaidAccountDAO.findById(mobileNo).get();
		postpaidAccount.setPlan(planDAO.findById(planID).get());
		return true;
	}

	@Override
	public boolean closeCustomerPostPaidAccount(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException {
		customer=customerDAO.findById(customerID).get();
		postpaidAccounts = customer.getPostpaidAccounts();
		postpaidAccount = postpaidAccounts.get(mobileNo);
		postPaidAccountDAO.deleteById(postpaidAccount.getMobileNo());
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerID)
			throws BillingServicesDownException, CustomerDetailsNotFoundException {
		/*customer = customerDAO.findById(customerID).get();
		postpaidAccounts=customer.getPostpaidAccounts();
		Iterable<PostpaidAccount> postpaidAccountToBeDeleted = postpaidAccounts.values();
		postPaidAccountDAO.deleteInBatch(postpaidAccountToBeDeleted);*/
		customerDAO.deleteById(customerID);
		return false;
	}

	@Override
	public Plan getCustomerPostPaidAccountPlanDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			PlanDetailsNotFoundException {
		postpaidAccount=postPaidAccountDAO.findById(mobileNo).get();
		plan = postpaidAccount.getPlan();
		return plan;
	}



}