package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ContactDao;
import com.model.Address;
import com.model.Contact;

@Controller
public class ContactController {

	private ContactDao contactDao;

	@Autowired
	public ContactController(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	@GetMapping("/contactform")
	public String showContactform(Model model) {
		return "contact_form";
	}
	
	@GetMapping("/viewallcontacts")
	public String viewAllContats(Model model) {
		List<Contact> contacts = contactDao.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "viewallcontacts";
	}
	
	
	@GetMapping({"/","index1"})
	public String showIndex(Model model) {
		model.addAttribute("message","Hello user");
		return "index";
	}
	

	@PostMapping("/addContact")
	public ModelAndView addContact(@RequestParam("name") String name,
			@RequestParam("number") int number,
			@RequestParam("email") String email,
			@RequestParam("category") String category,
			@RequestParam("addressLine") String addressLine,
			@RequestParam("pincode") int pincode,
			@RequestParam("city") String city) {
		
		contactDao.addContact(new Contact(name,number,email,category,new Address(0,addressLine,city,pincode)));
		ModelAndView modelAndView = new ModelAndView("redirect:/contactform");
		return modelAndView;
	}
	

	@GetMapping("/removecontact")
	public String deleteContact(@RequestParam("id") int id) {
		contactDao.deleteContact(id);
		return "redirect:/viewallcontacts";
	}
	
	
	
	int updateID=0;
	@GetMapping("/update")
	public ModelAndView getContactID(@RequestParam("id") int id) {
	updateID = id;
	
	ModelAndView mav = new ModelAndView("update");
	
	Contact contact = contactDao.getContactbyId(updateID);
	mav.addObject("contact",contact);	
	return mav;
	}
	
	
	@PostMapping("/update1")
	public ModelAndView setUpdate(@RequestParam("name") String name,
		@RequestParam("number") int number,
		@RequestParam("email") String email,
		@RequestParam("category") String category,
		@RequestParam("addressLine") String addressLine,
		@RequestParam("pincode") int pincode,
		@RequestParam("city") String city)
	{
	ModelAndView mav = new ModelAndView("redirect:/viewallcontacts");
	contactDao.updateContact(name,updateID, number, email, category,new Address(0,addressLine,city,pincode));
	return mav;	
	}
	
	@GetMapping("searchcontact")
	public String searchContact() {
		return "search_contact";
	}
	
	@PostMapping("/search1")
	public ModelAndView search(@RequestParam("name") String name)
	{
		List<Contact> contacts = contactDao.searchContactsByName(name);
		ModelAndView mav = new ModelAndView("search_contact");
		mav.addObject("contacts",contacts);
		return mav;
	}
	
	@GetMapping("searchcontact2")
	public String searchbyCategory() {
		return "searchbycategory";
	}
	
	@PostMapping("/search2")
	public ModelAndView search2(@RequestParam("category") String category)
	{
		List<Contact> contacts = contactDao.searchContactsByCategory(category);
		ModelAndView mav = new ModelAndView("searchbycategory");
		mav.addObject("contacts",contacts);
		return mav;
	}
	
}
