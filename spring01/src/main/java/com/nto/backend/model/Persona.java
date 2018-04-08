package com.nto.backend.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Persona {
	
	private Integer id;
	@NotNull
	@Size(min=3, max=30)
	private String nombre;
	@NotNull
	@Size(min=3, max=30)
	private String profesion;
	@NotNull
	private Integer sueldo;
	
	public Persona() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}
	

}
