package com.contact.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	private ContactRepository contactRepository;
	
	public void createContactInfo(ContactDto contactDto) {
		
		ContactEntity contact = new ContactEntity();
		contact.setEmail(contactDto.getEmail());
		
		NameDto nameDto = contactDto.getName();
		NameEntity nameEntity = new NameEntity();
		
		nameEntity.setFirst(nameDto.getFirst());
		nameEntity.setMiddle(nameDto.getMiddle());
		nameEntity.setLast(nameDto.getLast());
		
		nameEntity.setContact(contact);
		
		AddressDto addressDto = contactDto.getAddress();
		AddressEntity addressObj = new AddressEntity();
		
		addressObj.setStreet(addressDto.getStreet());
		addressObj.setCity(addressDto.getCity());
		addressObj.setState(addressDto.getState());
		addressObj.setZip(addressDto.getZip());
		addressObj.setContact(contact);
		contact.setAddress(addressObj);
		
		List<PhoneDto> phoneDto = contactDto.getPhone();
		
		List<PhoneEntity> phoneEntities = new ArrayList<PhoneEntity>();
		for (PhoneDto p : phoneDto) {
			
			PhoneEntity phoneEntity = new PhoneEntity();
			phoneEntity.setNumber(p.getNumber());
			phoneEntity.setType(p.getType());
			phoneEntity.setContact(contact);
			contact.setPhone(phoneEntities);
			phoneEntities.add(phoneEntity);
			
			contactRepository.save(contact);
			
		}
	}

	public ContactDto getContact(int id) {
		
		Optional<ContactEntity> contact = contactRepository.findById(id);

		ContactDto contactDto = null;

		if (contact.isPresent()) {
			contactDto = new ContactDto();
			contactDto.setEmail(contact.get().getEmail());

			NameEntity nameEntity = contact.get().getName();
			NameDto nameDto = new NameDto();
			nameDto.setFirst(nameEntity.getFirst());
			nameDto.setMiddle(nameEntity.getMiddle());
			nameDto.setLast(nameEntity.getLast());
			contactDto.setName(nameDto);

			AddressEntity addressEntity = contact.get().getAddress();
			AddressDto addressDto = new AddressDto();
			addressDto.setStreet(addressEntity.getStreet());
			addressDto.setCity(addressEntity.getCity());
			addressDto.setState(addressEntity.getState());
			addressDto.setZip(addressEntity.getZip());
			contactDto.setAddress(addressDto);

			List<PhoneEntity> phoneEntity = contact.get().getPhone();

			List<PhoneDto> phoneDto = new ArrayList<PhoneDto>();

			for (PhoneEntity p : phoneEntity) {
				PhoneDto phoneDtos = new PhoneDto();
				phoneDtos.setNumber(p.getNumber());
				phoneDtos.setType(p.getType());
				phoneDto.add(phoneDtos);
				contactDto.setPhone(phoneDto);

			}
		}
		return contactDto;
	}
		
	public List<ContactDto> getAllContacts() {
		Iterable<ContactEntity> contact= contactRepository.findAll();

		List<ContactDto> contactDto = new ArrayList<ContactDto>();
		for (ContactEntity m : contact) {
			ContactDto mainDto = new ContactDto();
			mainDto.setEmail(m.getEmail());

			NameEntity nameEntity = m.getName();
			NameDto nameDto = new NameDto();
			nameDto.setFirst(nameEntity.getFirst());
			nameDto.setLast(nameEntity.getLast());
			nameDto.setMiddle(nameEntity.getMiddle());
			mainDto.setName(nameDto);

			AddressEntity addressEntity = m.getAddress();
			AddressDto addressDto = new AddressDto();
			addressDto.setStreet(addressEntity.getStreet());
			addressDto.setCity(addressEntity.getCity());
			addressDto.setState(addressEntity.getState());
			addressDto.setZip(addressEntity.getZip());
			mainDto.setAddress(addressDto);

			List<PhoneEntity> phoneEntity = m.getPhone();
			List<PhoneDto> phoneDtos = new ArrayList<PhoneDto>();
			if (phoneEntity != null) {
				for (PhoneEntity p : phoneEntity) {
					PhoneDto phoneDto = new PhoneDto();
					phoneDto.setNumber(p.getNumber());
					phoneDto.setType(p.getType());
					phoneDtos.add(phoneDto);
					mainDto.setPhone(phoneDtos);
				}

				contactDto.add(mainDto);

			}

		}
		return contactDto;

	}

	public void updateContacts(int id, ContactDto mainContactDto) {
		Optional<ContactEntity> contact = contactRepository.findById(id);
		if (contact.isPresent()) {
			ContactEntity mainContactEntity2 = contact.get();
			mainContactEntity2.setEmail(mainContactDto.getEmail());
			
			NameEntity nameEntity = mainContactEntity2.getName();
			NameDto nameDto = mainContactDto.getName();
			nameEntity.setFirst(nameDto.getFirst());
			nameEntity.setMiddle(nameDto.getMiddle());
			nameEntity.setLast(nameDto.getLast());
			nameEntity.setContact(mainContactEntity2);
			mainContactEntity2.setName(nameEntity);

			AddressEntity addressEntity = mainContactEntity2.getAddress();
			AddressDto addressDto = mainContactDto.getAddress();
			addressEntity.setStreet(addressDto.getStreet());
			addressEntity.setState(addressDto.getState());
			addressEntity.setCity(addressDto.getCity());
			addressEntity.setZip(addressDto.getZip());
			addressEntity.setContact(mainContactEntity2);
			mainContactEntity2.setAddress(addressEntity);

			List<PhoneEntity> phoneEntities = mainContactEntity2.getPhone();
			List<PhoneDto> phoneDtos = mainContactDto.getPhone();

			if (phoneDtos != null) {
				for (PhoneDto p : phoneDtos) {
					if(phoneEntities == null) {
					PhoneEntity phoneEntity = new PhoneEntity();
					phoneEntity.setNumber(p.getNumber());
					phoneEntity.setType(p.getType());
					phoneEntity.setContact(mainContactEntity2);
					phoneEntities.add(phoneEntity);

					mainContactEntity2.setPhone(phoneEntities);
					}
					
					else {
						
						mainContactEntity2.setPhone(phoneEntities);
					}
				}
			}
			contactRepository.save(mainContactEntity2);
		}

	}

}