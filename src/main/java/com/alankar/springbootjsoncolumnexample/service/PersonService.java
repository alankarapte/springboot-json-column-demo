package com.alankar.springbootjsoncolumnexample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alankar.springbootjsoncolumnexample.domain.Address;
import com.alankar.springbootjsoncolumnexample.domain.Person;
import com.alankar.springbootjsoncolumnexample.dto.AddressDTO;
import com.alankar.springbootjsoncolumnexample.dto.PersonDTO;
import com.alankar.springbootjsoncolumnexample.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<PersonDTO> findPersons() {
		List<Person> persons = personRepository.findAll();

		return persons.stream()
				.map( (person) -> {
					PersonDTO personDTO = new PersonDTO();
					AddressDTO addressDTO = new AddressDTO();
					BeanUtils.copyProperties(personDTO, person);
					BeanUtils.copyProperties(addressDTO, person.getAddressPermanent());
					personDTO.setAddressPermanent(addressDTO);

					return personDTO;
				}).collect(Collectors.toList());		 
	}

	public void addPerson(PersonDTO personDTO) {
		Person person = new Person();
		Address address = new Address();

		BeanUtils.copyProperties(person, personDTO);
		BeanUtils.copyProperties(address, personDTO.getAddressPermanent());
		person.setAddressPermanent(address);

		personRepository.save(person);		
	}
}
