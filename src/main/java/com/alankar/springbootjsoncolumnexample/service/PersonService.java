package com.alankar.springbootjsoncolumnexample.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
					BeanUtils.copyProperties(addressDTO, person.getAddressTemporary());
					personDTO.setAddressTemporary(addressDTO);
					return personDTO;
				}).collect(Collectors.toList());		 
	}
}
