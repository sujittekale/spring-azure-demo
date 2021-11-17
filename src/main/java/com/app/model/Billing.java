package com.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="billing")
public class Billing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	@Column (name="address")
	private String address;
	@Column(name="billing_address")
	private boolean billingAddress=true;
	@Column(name="bilstate_other")
	private String bilstateOther;
	@Column(name="city")
	private String city;
    @Column(name="company")
    private String company;
    @Column(name="country")
    private String country;
    @Column(name="country_code")
    private String countryCode;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="latitude")
    private String latitude;
    @Column(name="longitude")
    private String longitude;
    @Column(name="phone")
    private String phone;
    @Column(name="postal_code")
    private String postalCode;
    @Column(name="state_provience")
    private String stateProvience;
    @Column(name="zone")
    private String zone;
    
}

