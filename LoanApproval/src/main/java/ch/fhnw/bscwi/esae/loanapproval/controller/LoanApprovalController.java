/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.loanapproval.controller;

import ch.fhnw.bscwi.esae.loanapproval.domain.Customer;
import ch.fhnw.bscwi.esae.loanapproval.service.CustomerService;
import ch.fhnw.bscwi.esae.loanapproval.service.ProcessRequestService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author andreas.martin
 */
@Named(value = "loanApprovalController")
@SessionScoped //we need a session!
public class LoanApprovalController implements Serializable{
    
    @Inject
    private CustomerService customerService;
    private Customer customer;
    @Inject
    private ProcessRequestService processRequestService;
    private Long amount;

    /**
     * Creates a new instance of CustomerController
     */
    public LoanApprovalController() {
    }
    
    public Customer getCustomer() {
        if(customer== null)
            customer = new Customer();
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Long getAmount() {
        return amount;
    }
    
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    
    public String doLoadCustomer() {
        customer = customerService.loadCustomer(customer.getId());
        return "loanApprovalCase";
    }
    
    public String doProcessRequest() {
        processRequestService.processRequest(customer.getId(), getAmount());
        return "loadCustomerCase";
    }
    
}
