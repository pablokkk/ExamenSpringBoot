package com.example.examen_springboot_pablorobles.controller;

import com.example.examen_springboot_pablorobles.model.Alumno;
import com.example.examen_springboot_pablorobles.repository.AlumnoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alumnado")
public class AlumnoControllerREST {
    @Autowired
    AlumnoRepo repo;

    @GetMapping
    public List<Alumno> getAll() {
        return (List<Alumno>) repo.findAll();
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @GetMapping("/suspensos/{modulo}")
    public ResponseEntity<Alumno> getAllSuspensoByModulo(@PathVariable String modulo) {
        List<Alumno> alumnos = getAll();
        ArrayList<Alumno> result = new ArrayList<>();
        if (modulo.equals("ad")) {
            for (Alumno a : alumnos) {
                if (a.getNotaAD() < 5) {
                    result.add(a);
                }
            }
            return new ResponseEntity(result, HttpStatus.OK);
        } else if (modulo.equals("di")) {
            for (Alumno a : alumnos) {
                if (a.getNotaDI() < 5) {
                    result.add(a);
                }
            }
            return new ResponseEntity(result, HttpStatus.OK);
        } else {
            // Modulo erroneo
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
