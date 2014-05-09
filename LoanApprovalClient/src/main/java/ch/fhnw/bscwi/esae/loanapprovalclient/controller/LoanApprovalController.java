/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.loanapprovalclient.controller;

import ch.fhnw.bscwi.esae.loanapprovalclient.CustomerWebService.client.CustomerDTO;
import ch.fhnw.bscwi.esae.loanapprovalclient.CustomerWebService.client.CustomerWebService;
import ch.fhnw.bscwi.esae.loanapprovalclient.CustomerWebService.client.CustomerWebService_Service;
import ch.fhnw.bscwi.esae.loanapprovalclient.ProcessRequestWebService.client.ProcessRequestWebService;
import ch.fhnw.bscwi.esae.loanapprovalclient.ProcessRequestWebService.client.ProcessRequestWebService_Service;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author andreas.martin
 */
@Named(value = "loanApprovalController")
@SessionScoped //we need a session!
public class LoanApprovalController implements Serializable{
    
    @WebServiceRef(CustomerWebService_Service.class)
    private CustomerWebService customerService;
    private CustomerDTO customer;
    @WebServiceRef(ProcessRequestWebService_Service.class)
    private ProcessRequestWebService processRequestService;
    private Long amount;

    /**
     * Creates a new instance of CustomerController
     */
    public LoanApprovalController() {
    }
    
    public CustomerDTO getCustomer() {
        if(customer== null)
            customer = new CustomerDTO();
        return customer;
    }
    
    public void setCustomer(CustomerDTO customer) {
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
