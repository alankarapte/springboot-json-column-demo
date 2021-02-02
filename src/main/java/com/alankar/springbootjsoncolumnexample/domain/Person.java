package com.alankar.springbootjsoncolumnexample.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Column( columnDefinition = "json")
	@Basic(fetch = FetchType.LAZY)
	private Address addressPermanent;
}
