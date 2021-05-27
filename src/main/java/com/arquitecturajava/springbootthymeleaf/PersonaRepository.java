package com.arquitecturajava.springbootthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository {
    @Autowired
    private JdbcTemplate plantilla;

    public List<Persona> buscarTodos() {
        return plantilla.query("select * from Personas", new PersonaMapper());
    }

    public void borrar(Persona persona) {
        //Query borrar personas MYSQL con springBoot JDBC Starter
        plantilla.update("delete from Personas where nombre=?", persona.getNombre());
    }

    public void insertar(Persona persona) {

        plantilla.update("intert into Personas (nombre, apellidos, edad) values (?,?,?)", persona.getNombre(), persona.getApellidos(), persona.getNombre());
    }
}
