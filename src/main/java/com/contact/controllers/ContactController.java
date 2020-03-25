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
	public List<ContactDto> getcontact(ContactDto contactDto) {
		return contactService.getContactDetails(contactDto);
	}
	
	@PostMapping(value ="/post")
	public void createContact(@RequestBody ContactDto dto) {
		System.out.println(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ContactDto getById(@PathVariable("id") Integer id) {
		return contactService.getById(id);
	}
	
	@DeleteMapping(value="/delete")
	public List<ContactDto> deleteById(@PathVariable("id") Integer id) {
		return contactService.deleteById(id);
	}
	
	
	
}
