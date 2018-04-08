package com.nto.backend.dao;

import java.util.List;

import com.nto.backend.model.Persona;

public interface PersonaDao {
	
	public List<Persona> personaList();
	
	public void personaCreate(Persona persona);
	
	public Persona personaFind(Integer id);
	
	public void personaUpdate(Persona persona);
	
	public void personaDelete(Integer id);
	
}
