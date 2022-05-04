package com.cenfotec.examen3.entities;

import javax.persistence.*;

@Entity
public class Libro {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int idhijo;

    @Column(nullable = false)
    private String nombre;

    private boolean estado;

    public Libro() {
    }

    public Libro(int id, int idJHijo, String nombre) {
        this.id = id;
        this.idhijo = idJHijo;
        this.nombre = nombre;
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdhijo() {
        return idhijo;
    }

    public void setIdhijo(int idhijo) {
        this.idhijo = idhijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
