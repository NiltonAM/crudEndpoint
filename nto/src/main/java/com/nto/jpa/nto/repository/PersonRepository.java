/*
 * 
 * author: Nilton Arotingo - date: 13/04/2018 - Request: Create Jpa project
 */
package com.nto.jpa.nto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nto.jpa.nto.model.Person;

/**
 * The Interface PersonRepository.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
