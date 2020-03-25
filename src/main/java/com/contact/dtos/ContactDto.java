package com.contact.dtos;

import java.io.Serializable;

public class ContactDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Integer id;
	public NameDto name;
	public AddressDto address;
	public PhoneDto phone;
	private String email;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public NameDto getName() {
		return name;
	}
	public void setName(NameDto name) {
		this.name = name;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public PhoneDto getPhone() {
		return phone;
	}
	public void setPhone(PhoneDto phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "ContactDto [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email="
				+ email + "]";
	}
	

	
	
}
