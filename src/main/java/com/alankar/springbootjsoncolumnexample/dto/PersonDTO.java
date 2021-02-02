package com.alankar.springbootjsoncolumnexample.dto;

import javax.persistence.Column;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class PersonDTO {
	
	private String name;
	private int age;
	
	@Type(type = "jsonb")
    @Column( columnDefinition = "jsonb")
	private AddressDTO addressPermanent;			//demo jsonb

	@Type(type = "json")
    @Column( columnDefinition = "json")
	private AddressDTO addressTemporary;			//demo json
}
