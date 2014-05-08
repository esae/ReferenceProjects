/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.lendingreferenceproject1.controller;

import ch.fhnw.bscwi.esae.lendingreferenceproject1.business.CustomerEJB;
import ch.fhnw.bscwi.esae.lendingreferenceproject1.domain.Customer;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;


/**
 *
 * @author andreas.martin
 */
@Named
@SessionScoped
public class CustomerController implements Serializable{

    public CustomerController() {
    }
    @EJB
    private CustomerEJB customerEJB;
    private Customer customer;
    private List<Customer> customerList;
    private HtmlDataTable customerHtmlDataTable;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {
        customerList = customerEJB.findCustomers();
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public String prepareCreateCustomer()
    {
        this.customer = new Customer();
        return "newCustomerCase";
    }

    public String doCreateCustomer() {
        customer = customerEJB.createCustomer(customer);
        customerList = customerEJB.findCustomers();
        return "listCustomersCase";
    }
    
    public HtmlDataTable getCustomerHtmlDataTable() {
        return customerHtmlDataTable;
    }

    public void setCustomerHtmlDataTable(HtmlDataTable customerHtmlDataTable) {
        this.customerHtmlDataTable = customerHtmlDataTable;
    }
    
    public String prepareEditCustomer()
    {
        this.customer = (Customer) this.customerHtmlDataTable.getRowData();
        return "editCustomerCase";
    }
    
    public String doEditCustomer()
    {
        customer=customerEJB.updateCustomer(customer);
        customerList = customerEJB.findCustomers();
        return "listCustomersCase";
    }
    
    public String doDeleteCustomer()
    {
        this.customer = (Customer) this.customerHtmlDataTable.getRowData();
        customerEJB.deleteCustomer(customer);
        customer=new Customer();
        customerList = customerEJB.findCustomers();
        return "listCustomersCase";
    }
    
}