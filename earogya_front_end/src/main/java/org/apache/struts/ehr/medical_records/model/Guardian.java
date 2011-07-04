package org.apache.struts.ehr.medical_records.model;

import java.util.ArrayList;

public class Guardian {

	private String prefix;
	private String given_name;
	private String surname;
	private String furthur_names;
	private String nic_no;
	private Address addresses;
	private String telephoneNumbers;
	private String email;
	
	public Address getAddresses() {
		return addresses;
	}
	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}
	public String getTelephoneNumbers() {
		return telephoneNumbers;
	}
	public void setTelephoneNumbers(String telephoneNumbers) {
		this.telephoneNumbers = telephoneNumbers;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String givenName) {
		given_name = givenName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFurthur_names() {
		return furthur_names;
	}
	public void setFurthur_names(String furthurNames) {
		furthur_names = furthurNames;
	}
	public String getNic_no() {
		return nic_no;
	}
	public void setNic_no(String nicNo) {
		nic_no = nicNo;
	}

	
	
}
