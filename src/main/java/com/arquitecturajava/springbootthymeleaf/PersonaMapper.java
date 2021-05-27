package com.arquitecturajava.springbootthymeleaf;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper implements RowMapper<Persona> {
    @Override
    public Persona mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Persona(resultSet.getString("nombre"), resultSet.getString("apellidos"), resultSet.getInt("edad"));
    }
}
