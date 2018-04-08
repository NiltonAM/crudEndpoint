package com.nto.backend.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nto.backend.dao.PersonaDao;
import com.nto.backend.model.Persona;

@Repository
public class PersonaDaoImpl implements PersonaDao {
	
	private static final String LIST_PERSONA_SQL = "SELECT ID, NOMBRE, PROFESION, SUELDO FROM PERSONA";
	private static final String CREATE_PERSONA_SQL = "INSERT INTO PERSONA(NOMBRE, PROFESION, SUELDO) VALUES(?,?,?)";
	private static final String FIND_PERSONA_SQL = "SELECT ID, NOMBRE, PROFESION, SUELDO FROM PERSONA WHERE ID=?";
	private static final String UPDATE_PERSONA_SQL = "UPDATE PESONA SET NOMBRE=?, PROFESION=?, SUELDO=? WHERE ID=?";
	private static final String DELETE_PERSONA_SQL = "DELETE FROM PERSONA WHERE ID=?";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PersonaDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static final class PersonaRowMapper implements RowMapper<Persona>{

		@Override
		public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
			Persona persona = new Persona();
			persona.setId(rs.getInt("ID"));
			persona.setNombre(rs.getString("NOMBRE"));
			persona.setProfesion(rs.getString("PROFESION"));
			persona.setSueldo(rs.getInt("SUELDO"));
			return persona;
		}
		
	}	

	@Override
	public List<Persona> personaList() {
		return jdbcTemplate.query(LIST_PERSONA_SQL, new PersonaRowMapper());
	}

	@Override
	public void personaCreate(Persona persona) {
		jdbcTemplate.update(CREATE_PERSONA_SQL, persona.getNombre(), persona.getProfesion(), persona.getSueldo());
		
	}

	@Override
	public Persona personaFind(Integer id) {
		return jdbcTemplate.queryForObject(FIND_PERSONA_SQL, new PersonaRowMapper(), id);
	}

	@Override
	public void personaUpdate(Persona persona) {
		jdbcTemplate.update(UPDATE_PERSONA_SQL, persona.getNombre(), persona.getProfesion(), persona.getSueldo(), persona.getId());
	}

	@Override
	public void personaDelete(Integer id) {
		jdbcTemplate.update(DELETE_PERSONA_SQL, id);
	}

}
