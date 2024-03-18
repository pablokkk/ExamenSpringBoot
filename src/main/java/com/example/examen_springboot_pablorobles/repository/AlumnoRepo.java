package com.example.examen_springboot_pablorobles.repository;

import com.example.examen_springboot_pablorobles.model.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepo extends CrudRepository<Alumno, Long> {

}
