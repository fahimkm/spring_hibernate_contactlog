package com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
	private String  addressLine;
	private String city;
	private int pincode;
	
	
	
	public Address() {
	}
	
	
	
	public Address(int id, String addressLine, String city, int pincode) {
		super();
		this.addId = id;
		this.addressLine = addressLine;
		this.city = city;
		this.pincode = pincode;
	}



	public int getId() {
		return addId;
	}
	public void setId(int id) {
		this.addId = id;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Address [addressline=" + addressLine + ", city=" + city + ", pincode =" + pincode + "]" ;
	}
	
	
}
