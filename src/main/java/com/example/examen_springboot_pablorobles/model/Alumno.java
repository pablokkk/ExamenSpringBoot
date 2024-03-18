package com.example.examen_springboot_pablorobles.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "alumnado")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    String nombre;
    @Column
    String telefono;
    @Column
    String email;
    @Column(name = "ad")
    Double notaAD;
    @Column(name = "di")
    Double notaDI;

    public Alumno() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno(String nombre, String telefono, String email, Double notaAD, Double notaDI) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.notaAD = notaAD;
        this.notaDI = notaDI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getNotaAD() {
        return notaAD;
    }

    public void setNotaAD(Double notaAD) {
        this.notaAD = notaAD;
    }

    public Double getNotaDI() {
        return notaDI;
    }

    public void setNotaDI(Double notaDI) {
        this.notaDI = notaDI;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", notaAD=" + notaAD +
                ", notaDI=" + notaDI +
                '}';
    }
}
