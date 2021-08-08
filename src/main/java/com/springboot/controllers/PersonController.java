package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dtos.PersonResponseDTO;
import com.springboot.entities.Person;
import com.springboot.forms.PersonForm;
import com.springboot.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	private PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	public PersonResponseDTO create(@RequestBody PersonForm createPersonForm) {
		
		Person person = new Person();
		
		person.setName(createPersonForm.getName());
		person.setAge(createPersonForm.getAge());
		
		Person personCreated = personService.create(person);
		
		return new PersonResponseDTO(personCreated.getId(), personCreated.getName(), personCreated.getAge());
		
	}
	
}
