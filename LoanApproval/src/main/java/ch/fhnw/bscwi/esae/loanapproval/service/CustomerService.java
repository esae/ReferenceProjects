/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.loanapproval.service;

import ch.fhnw.bscwi.esae.loanapproval.domain.Customer;
import ch.fhnw.bscwi.esae.loanapproval.ejb.CustomerEJB;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author andreas.martin
 */
@Named
@RequestScoped
public class CustomerService {

    @EJB
    CustomerEJB customerEJB;

    public Customer loadCustomer(Long customerId) {
        return customerEJB.findCustomerById(customerId);
    }
}
