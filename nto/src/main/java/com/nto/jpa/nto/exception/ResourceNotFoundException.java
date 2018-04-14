/*
 * 
 * author: Nilton Arotingo - date: 13/04/2018 - Request: 
 */
package com.nto.jpa.nto.exception;

/**
 * The Class ResourceNotFoundException.
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;

	/**
	 * Constructor.
	 *
	 * @param resourceName
	 *            the resource name
	 * @param fieldName
	 *            the field name
	 * @param fieldValue
	 *            the field value
	 */
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	/**
	 * Gets the resource name.
	 *
	 * @return the resource name
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * Gets the field name.
	 *
	 * @return the field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Gets the field value.
	 *
	 * @return the field value
	 */
	public Object getFieldValue() {
		return fieldValue;
	}

}
