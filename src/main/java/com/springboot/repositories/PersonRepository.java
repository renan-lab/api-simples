package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}