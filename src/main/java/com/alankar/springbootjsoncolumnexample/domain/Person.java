package com.alankar.springbootjsoncolumnexample.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor 
public class Person extends EntityWithUUID {
	
	private String name;
	private int age;
	
	@Type(type = "jsonb")
    @Column( columnDefinition = "jsonb")
	private Address addressPermanent;			//demo jsonb

	@Type(type = "json")
    @Column( columnDefinition = "json")
	private Address addressTemporary;			//demo json
}
