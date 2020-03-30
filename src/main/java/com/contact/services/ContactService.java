package com.contact.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contact.dtos.AddressDto;
import com.contact.dtos.ContactDto;
import com.contact.dtos.NameDto;
import com.contact.dtos.PhoneDto;
import com.contact.entities.AddressEntity;
import com.contact.entities.ContactEntity;
import com.contact.entities.NameEntity;
import com.contact.entities.PhoneEntity;
import com.contact.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactrepository;

	public void createContact(ContactDto dto) {
		ContactEntity entity = new ContactEntity();
	
		NameEntity nameentity = new NameEntity();
		NameDto namedto = dto.getName();
		nameentity.setFirst(namedto.getFirst());
		nameentity.setMiddle(namedto.getMiddle());
		nameentity.setLast(namedto.getLast());
		nameentity.setContact(entity);
		entity.setName(nameentity);

		AddressEntity addressentity = new AddressEntity();
		AddressDto addressdto = dto.getAddress();
		addressentity.setStreet(addressdto.getStreet());
		addressentity.setCity(addressdto.getCity());
		addressentity.setState(addressdto.getState());
		addressentity.setZip(addressdto.getZip());
		addressentity.setContact(entity);
		entity.setAddress(addressentity);

		List<PhoneEntity> phoneentity = new ArrayList<PhoneEntity>();
		List<PhoneDto> phonedto = dto.getPhone();

		for (PhoneDto phone : phonedto) {
			PhoneEntity entity = new PhoneEntity();
			entity.setNumber(phone.getNumber());
			entity.setType(phone.getType());
			entity.setContact(entity);

			phoneentity.add(entity11);
		}
		entity.setPhone(phoneentity);
		entity.setEmail(dto.getEmail());

		contactrepository.save(entity);

	}
}


}

	public void create(ContactDto dto) {
		ContactDto.add(dto);
	}

	public ContactDto getById(Integer id) {
		for (ContactDto c : contact) {
			Integer i = c.getId();
			if (i == id) {
				return c;
			}

		}
		return null;
	}
	
	public List<ContactDto> deleteById(Integer id) {
		for (ContactDto c : contact) {
			if (c.getId()==id) {
				contact.remove(c);
			}
		}
	return contact;
	}
	
}


//Previous code for calling my APIs
/*List <ContactDto> contact;
public List<ContactDto> getContactDetails(ContactDto contactDto) {
	contact = new ArrayList<ContactDto>();
	
	NameDto name = new NameDto();
	name.setFirst("Loic");
	name.setLast("Ipanga");
	name.setMiddle("Nyeka");
	AddressDto address = new AddressDto("Second Street", "Delhi", "NCR", "22042");
	PhoneDto phone = new PhoneDto("5717333413", "mobile");
	
	ContactDto c1 = new ContactDto();
	c1.setId(1);
	c1.setName(name);
	c1.setPhone(phone);
	c1.setAddress(address);
	c1.setEmail("ipangaloic@email.com");
	contact.add(c1);
	
	NameDto name2 = new NameDto();
	name2.setFirst("Friend");
	name2.setLast("Best");
	name2.setMiddle("Forever");
	
	AddressDto address2 = new AddressDto("Third Street", "Reston", "Virginia", "22042");
	PhoneDto phone2 = new PhoneDto("5717334747", "mobile");
	
	ContactDto c2 = new ContactDto();
	c2.setId(2);
	c2.setName(name2);
	c2.setPhone(phone2);
	c2.setAddress(address2);
	c2.setEmail("restonprogramc@email.com");
	contact.add(c2);
	
	return contact;*/