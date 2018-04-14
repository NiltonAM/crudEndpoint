/*
 * 
 * author: Nilton Arotingo - date: 13/04/2018 - Request: 
 */
package com.nto.jpa.nto.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nto.jpa.nto.exception.ResourceNotFoundException;
import com.nto.jpa.nto.model.Person;
import com.nto.jpa.nto.repository.PersonRepository;

/**
 * The Class PersonEndpoint.
 */
@RestController
@RequestMapping(value = "/person")
public class PersonEndpoint {
	
	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@GetMapping("/all")
	public List<Person> getAll() {
		return personRepository.findAll();
	}
	
	/**
	 * Creates the.
	 *
	 * @param person
	 *            the person
	 * @return the person
	 */
	@PostMapping("/save")
	public Person create(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the person
	 */
	@GetMapping("/get/{id}")
	public Person findById(@PathVariable(value="id") Integer id) {
		return personRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
	}
	
	/**
	 * Update.
	 *
	 * @param id
	 *            the id
	 * @param person
	 *            the person
	 * @return the person
	 */
	@PutMapping("/update/{id}")
	public Person update(@PathVariable(value = "id") Integer id, @Valid @RequestBody Person person) {
		Person persona = personRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
		
		persona.setFirstname(person.getFirstname());
		persona.setLastname(person.getLastname());
		persona.setCellphone(person.getCellphone());
		
		Person personUpd = personRepository.save(persona);
		
		return personUpd;
	}
	
	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 * @return the responseEntity
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
		
		Person person = personRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
		
		personRepository.delete(person);
		
		return ResponseEntity.ok().build();
	}
	
}
