package com.nto.backend.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nto.backend.DaoImpl.PersonaDaoImpl;
import com.nto.backend.model.Persona;

@RestController
@RequestMapping(value="/persona")
public class PersonaEndpoint {

	private PersonaDaoImpl personaDao;
	
	@Autowired
	public PersonaEndpoint(PersonaDaoImpl personaDao) {
		this.personaDao = personaDao;
	}
	

	public String hola(){
		return "Hola";
	}
	
	@CrossOrigin
	@RequestMapping(value="/listar", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> lista = personaDao.personaList();
		if(lista.isEmpty()) {
			return new ResponseEntity<List<Persona>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value="/registrar", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Void> insertar(@RequestBody Persona persona, UriComponentsBuilder ucb){
		personaDao.personaCreate(persona);
		HttpHeaders headers = new HttpHeaders();
		URI locationUri = ucb.path("/persona/registrar").build().toUri();
		headers.setLocation(locationUri);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/buscar/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Persona> buscar(@PathVariable("id") int id){
		Persona persona = personaDao.personaFind(id);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id, UriComponentsBuilder ucb){
		personaDao.personaDelete(id);
		HttpHeaders headers = new HttpHeaders();
		URI locationUri = ucb.path("/persona/eliminar").build().toUri();
		headers.setLocation(locationUri);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/actualizar", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Void> actualizar(@RequestBody Persona persona, UriComponentsBuilder ucb){
		personaDao.personaUpdate(persona);
		HttpHeaders headers = new HttpHeaders();
		URI locationUri = ucb.path("/persona/actualizar").build().toUri();
		headers.setLocation(locationUri);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
}
