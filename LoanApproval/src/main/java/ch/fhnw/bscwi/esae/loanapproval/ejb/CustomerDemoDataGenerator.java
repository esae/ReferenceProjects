/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.loanapproval.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import ch.fhnw.bscwi.esae.loanapproval.domain.Account;
import ch.fhnw.bscwi.esae.loanapproval.domain.Address;
import ch.fhnw.bscwi.esae.loanapproval.domain.Customer;


/**
 *
 * @author andreas.martin
 */
@Singleton
@Startup
public class CustomerDemoDataGenerator {
    
	@EJB
	CustomerEJB customerEJB;
	
	@PostConstruct
	public void init()
	{
		if(customerEJB.findCustomers().isEmpty()){
			Address address = new Address();
			address.setCity("Basel");
			List<Address> addresses = new ArrayList<Address>();
			addresses.add(address);
			
			Customer customer = new Customer();
			customer.setFirstName("Andreas");
			customer.setLastName("Martin");
			customer.setAddress(addresses);
			
			Account account = new Account();
			account.setBalance(200000);
			account.setName("Deposit account");
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(account);
			customer.setAccount(accounts);
			
			customerEJB.createCustomer(customer);
		}
	}
    
}
