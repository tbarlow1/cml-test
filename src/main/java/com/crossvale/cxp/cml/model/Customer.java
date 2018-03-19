package com.crossvale.cxp.cml.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Customer {

	private Integer customerNr;
	private String customerName;
	private String status;
	private String id;
	private String issuePlace;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date issueDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expirationDate;
	private PhoneNr phoneNr;
	private Address address;
	private String nationalityCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String email;

	
	public String getNationalityCode() {
		return nationalityCode;
	}

	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIssuePlace() {
		return issuePlace;
	}

	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}

	public Customer() {
    }
	
	public Customer(Integer customerNr, String customerName) {
        this.customerNr = customerNr;
        this.customerName = customerName;
    }
	
	public PhoneNr getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(PhoneNr phoneNr) {
		this.phoneNr = phoneNr;
	}

	public Integer getCustomerNr() {
		return customerNr;
	}

	public void setCustomerNr(Integer customerNr) {
		this.customerNr = customerNr;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
