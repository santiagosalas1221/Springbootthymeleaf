package com.arquitecturajava.springbootthymeleaf;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PersonaService {

	RestTemplate plantilla = new RestTemplate();

	public Iterable<Persona> buscarTodos() {

		//Peticion GET
		ResponseEntity<List<Persona>> respuesta = plantilla.exchange("http://localhost:8080/webapi/personas", HttpMethod.GET, null, new ParameterizedTypeReference<List<Persona>>() {});

		//Despues de obtener el body de la peticion GET de tipo JSON se convierte a lista de objetos
		List<Persona> personas = respuesta.getBody();
		return personas;
	}

	public void insertar (Persona persona) {
		//realiza peticion http post y envia la URL de objeto persona
		HttpEntity<Persona> peticion = new HttpEntity<>(persona);
		plantilla.postForObject("http://localhost:8080/webapi/personas", peticion, Persona.class);
	}

	public void borrar (Persona persona) {
		plantilla.delete("http://localhost:8080/webapi/personas/" + persona.getNombre());
	}
	
	
	
}
