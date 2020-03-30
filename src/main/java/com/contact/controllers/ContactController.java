package com.contact.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.dtos.ContactDto;
import com.contact.services.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping(value= "")
	public List<ContactDto> getAll() {
		return contactService.getAllContacts();
	}
	
	@PostMapping(value ="/post")
	public void createContact(@RequestBody ContactDto contactDto) {
		contactService.createContactInfo(contactDto);;
	}
	
	@GetMapping(value = "/{id}")
	public ContactDto getById(@PathVariable("id") Integer id) {
		return contactService.getContact(id);
	}
	
	/*@DeleteMapping(value="/delete")
	public List<ContactDto> deleteById(@PathVariable("id") Integer id) {
		return contactService.deleteById(id);
	}
	
	@PutMapping(value = "/{id}") 
	public void updateById(@PathVariable("id") int id, @RequestBody ContactDto mainContactDto) {
	contactService.updateContacts(id, mainContactDto);*/
}

