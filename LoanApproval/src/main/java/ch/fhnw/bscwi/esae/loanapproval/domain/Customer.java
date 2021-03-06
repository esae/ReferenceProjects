/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.loanapproval.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author andreas.martin
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findAll", query = "select c from Customer c"),
    @NamedQuery(name = "findByFirstName", query = "select c from Customer c where c.firstName = :fname")
})
@Table(name = "CUSTOMER_LOANAPPROVAL")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private Integer age;
    private String email;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_fk")
    private List<Address> address;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "loan_fk")
    private List<Loan> loan;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_fk")
    private List<Account> account;
    @ManyToOne
    @JoinColumn(name = "customerconsultant_fk")
    private CustomerConsultant customerConsultant;

    public CustomerConsultant getCustomerConsultant() {
        return customerConsultant;
    }

    public void setCustomerConsultant(CustomerConsultant customerConsultant) {
        this.customerConsultant = customerConsultant;
    }
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

    @PostLoad
    @PostPersist
    @PrePersist
    @PostUpdate
    public void calculateAge() {
        if (dateOfBirth == null) {
            age = null;
            return;
        }
        Calendar birth = new GregorianCalendar();
        birth.setTime(dateOfBirth);
        Calendar now = new GregorianCalendar();
        now.setTime(new Date());
        int adjust = 0;
        if (now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
            adjust = -1;
        }
        age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
    }

    /**
     * @return the address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }

	public List<Loan> getLoan() {
		return loan;
	}

	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
    
    
}
