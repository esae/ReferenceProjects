/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.loanapproval.dto;

import java.io.Serializable;

/**
 *
 * @author andreas.martin
 */
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String street1;
    private String city;
    private String zipcode;
    private String country;
    private String addressType;

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
     * @return the street1
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * @param street1 the street1 to set
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the type
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * @param type the type to set
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}
