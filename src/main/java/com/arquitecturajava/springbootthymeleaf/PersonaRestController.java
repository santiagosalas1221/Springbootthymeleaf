package com.arquitecturajava.springbootthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("webapi")
public class PersonaRestController {

    @Autowired
    PersonaRepository repositorio;


    @GetMapping("/personas")
    public Iterable<Persona> buscarTodos() {

        return repositorio.findAll();
    }

    @PostMapping(path = "/personas", consumes = "application/json")
    public void insertar (@RequestBody Persona persona) {
        repositorio.save(persona);
    }

    @DeleteMapping("/personas/{nombre}")
    public void borrar (@PathVariable String nombre) {

       Optional<Persona> persona = repositorio.findById(nombre);

       if (persona.isPresent()) {
           repositorio.delete(persona.get());
       }
    }

}
