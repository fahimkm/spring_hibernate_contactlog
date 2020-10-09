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
@Table(name = "Contacts")
public class Contact{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int number;
	private String email;
	private String category;
	
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addId")
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	
	public Contact() {
		super();
	}

	

	public Contact(String name, int number, String email, String category, Address address) {
		super();
		this.name = name;
		this.number = number;
		this.email = email;
		this.category = category;
		this.address = address;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", category=" + category + ", number =" + number + "email =" + email+"address = "+address+ "]" ;
	}
	
	
}
