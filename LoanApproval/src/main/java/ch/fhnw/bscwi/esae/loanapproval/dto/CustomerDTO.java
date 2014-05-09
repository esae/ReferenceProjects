/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.loanapproval.dto;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author andreas.martin
 */

public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer age;
    private String email;
    private List<AddressDTO> address;
    private List<LoanDTO> loan;
    private List<AccountDTO> account;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public List<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }

    public List<LoanDTO> getLoan() {
        return loan;
    }

    public void setLoan(List<LoanDTO> loan) {
        this.loan = loan;
    }

    public List<AccountDTO> getAccount() {
        return account;
    }

    public void setAccount(List<AccountDTO> account) {
        this.account = account;
    }



    
    
}
