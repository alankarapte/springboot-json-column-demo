package com.alankar.springbootjsoncolumnexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alankar.springbootjsoncolumnexample.dto.PersonDTO;
import com.alankar.springbootjsoncolumnexample.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("persons")
	public ResponseEntity<List<PersonDTO>> findAllPersons(){
		return ResponseEntity.ok().body(personService.findPersons());
	}

	@PostMapping("/persons")
	public ResponseEntity<?> addPerson(@RequestBody PersonDTO personDTO){
		personService.addPerson(personDTO);
		return ResponseEntity.ok().build();
	}
}
