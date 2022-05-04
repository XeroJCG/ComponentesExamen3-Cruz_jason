package com.cenfotec.examen3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PadreFamilia {
    @Id
    @Column(nullable = false)
    private int cedula;

    @Column(nullable = false)
    private String nombre;
    private String direccion;
    private int telefono1;
    private int telefono2;

    public PadreFamilia() {
    }

    public PadreFamilia(int cedula, String nombre, String direccion, int telefono1, int telefono2) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }

    @Override
    public String toString() {
        return "PadreFamilia{" +
                "Cedula=" + cedula +
                ", Nombre='" + nombre + '\'' +
                ", Direccion='" + direccion + '\'' +
                ", Telefono1=" + telefono1 +
                ", Telefono2=" + telefono2 +
                '}';
    }
}
