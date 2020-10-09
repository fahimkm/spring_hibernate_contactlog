package com.dao;

import java.util.List;

import com.model.Address;
import com.model.Contact;

public interface ContactDao {
	
	Contact getContact(String name);
	Contact getContactbyId(int id);
	List<Contact> getAllContacts();
	boolean addContact(Contact contact);
	boolean deleteContact(int number);
	boolean updateContact(String name, int id, int number, String email, String category, Address address);
	List<Contact> searchContactsByName(String name);
	List<Contact> searchContactsByCategory(String category);
}
