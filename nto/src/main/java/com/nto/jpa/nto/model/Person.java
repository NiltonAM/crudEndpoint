/*
 * 
 * author: Nilton Arotingo - date: 13/04/2018 - Request: 
 */
package com.nto.jpa.nto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The Class Person.
 */
@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String firstname;

	@NotBlank
	private String lastname;

	@NotNull
	private Integer cellphone;

	/**
	 * Constructor
	 */
	public Person() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname
	 *            the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname
	 *            the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the cellphone.
	 *
	 * @return the cellphone
	 */
	public Integer getCellphone() {
		return cellphone;
	}

	/**
	 * Sets the cellphone.
	 *
	 * @param cellphone
	 *            the new cellphone
	 */
	public void setCellphone(Integer cellphone) {
		this.cellphone = cellphone;
	}

}
