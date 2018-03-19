package com.crossvale.cxp.cml.model;

public class PhoneNr {
	
    private String phoneType;
	private String number;

    // constructor
	public PhoneNr(String phoneType, String number) {
		super();
		this.phoneType = phoneType;
		this.number = number;
	}
	
	
	public PhoneNr() {
		// TODO Auto-generated constructor stub
	}


	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
