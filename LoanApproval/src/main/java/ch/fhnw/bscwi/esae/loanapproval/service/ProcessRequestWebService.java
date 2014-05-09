/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.loanapproval.service;

import ch.fhnw.bscwi.esae.loanapproval.domain.Customer;
import ch.fhnw.bscwi.esae.loanapproval.domain.Loan;
import ch.fhnw.bscwi.esae.loanapproval.ejb.CustomerEJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author andreas.martin
 */
@WebService(serviceName = "ProcessRequestWebService")
public class ProcessRequestWebService {

    @EJB
    CustomerEJB customerEJB;

    public boolean processRequest(Long customerId, Long amount) {
        Customer customer = customerEJB.findCustomerById(customerId);

        Loan loan = new Loan();
        loan.setLoanType("default type");
        loan.setTerm("2 years");
        loan.setAmount(Long.parseLong(amount.toString()));
        List<Loan> loans = new ArrayList<>();
        loans.add(loan);
        customer.setLoan(loans);
        customerEJB.updateCustomer(customer);
        return true;
    }
}
