package com.alankar.springbootjsoncolumnexample.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alankar.springbootjsoncolumnexample.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

}
