package com.alankar.springbootjsoncolumnexample.domain;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

/*
 * @MappedSuperclass tells the JPA provider to include the base class persistent properties 
 * as if they were declared by the child class extending the superclass annotated with @MappedSuperclass.
 * 
 * However, the inheritance is only visible in the OOP world, 
 * since, from a database perspective, there's no indication of the base class. 
 * Only the child class entity will have an associated mapped table
 * 
 */
@MappedSuperclass
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
    @TypeDef(name = "json", typeClass = JsonStringType.class)
})
public class EntityWithUUID {
	@Id
	@Type(type = "pg-uuid")
	private UUID id;

	public EntityWithUUID() {
		this.id = UUID.randomUUID();
	}
}