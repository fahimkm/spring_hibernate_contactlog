package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Address;
import com.model.Contact;



@Repository
@Transactional
public class ContactDaoImp implements ContactDao{

	private SessionFactory sessionFactory;

	@Autowired
	public ContactDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 
	@Override
	public Contact getContact(String name) {
		return this.sessionFactory.getCurrentSession().get(Contact.class, name);
	}


	@Override
	public List<Contact> getAllContacts() {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Contact");
		List<Contact> contacts = query.list();
		return contacts;
	}

	@Override
	public boolean updateContact(String name,int id, int number, String email, String category,Address address) {
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			Contact contact = currentSession.get(Contact.class, id);
			contact.setId(id);
			contact.setName(name);
			contact.setCategory(category);
			contact.setEmail(email);
			contact.setNumber(number);
	
			Address address1 = currentSession.get(Address.class, id);
			address1.setId(id);
			address1.setAddressLine(address.getAddressLine());
			address1.setCity(address.getCity());
			address1.setPincode(address.getPincode());
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
		
	@Override
	public boolean addContact(Contact contact) {
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			currentSession.save(contact);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public boolean deleteContact(int id) {
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			Contact contact = currentSession.get(Contact.class, id);
			currentSession.delete(contact);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public List<Contact> searchContactsByName(String name) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Contact  c where c.name = :name",Contact.class);
		query.setParameter("name", name);
		List<Contact> contacts = query.list();
		return contacts;	
	}

	

	@Override
	public List<Contact> searchContactsByCategory(String category) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Contact c where c.category = :catg",Contact.class);
		query.setParameter("catg", category);
		List<Contact> contacts = query.list();
		return contacts;	
	}

	@Override
	public Contact getContactbyId(int id) {
	
		return this.sessionFactory.getCurrentSession().get(Contact.class, id);
	}

}
