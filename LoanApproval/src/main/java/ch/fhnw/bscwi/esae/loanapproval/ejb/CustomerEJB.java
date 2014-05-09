/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.loanapproval.ejb;

import ch.fhnw.bscwi.esae.loanapproval.domain.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author andreas.martin
 */
@Stateless
@Named
public class CustomerEJB {
    
    @PersistenceContext(unitName = "ch.fhnw.bscwi.esae_LoanApproval_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public Customer findCustomerById(Long id) {
    	return em.find(Customer.class, id);
    }

    public Customer createCustomer(Customer customer) {
        em.persist(customer);
        return customer;
    }

    public void deleteCustomer(Customer customer) {
        em.remove(em.merge(customer));
    }

    public Customer updateCustomer(Customer customer) {
        return em.merge(customer);
    }

    public List<Customer> findCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery("findAll", Customer.class);
        return query.getResultList();
    }
    
}
