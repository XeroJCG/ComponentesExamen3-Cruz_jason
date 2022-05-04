package com.cenfotec.examen3.entities;

import javax.persistence.*;

@Entity
public class Hijo {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String tipoPlan;

    private String alergias;

    private int cedulaPadre;

    public Hijo() {
    }

    public Hijo(int id, String nombre, String tipoPlan, int cedulaPadre) {
        this.id = id;
        this.nombre = nombre;
        this.tipoPlan = tipoPlan;
        this.cedulaPadre = cedulaPadre;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public int getCedulaPadre() {
        return cedulaPadre;
    }

    public void setCedulaPadre(int cedulaPadre) {
        this.cedulaPadre = cedulaPadre;
    }

    @Override
    public String toString() {
        return "Hijo{" +
                "Id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoPlan='" + tipoPlan + '\'' +
                ", cedulaPadre=" + cedulaPadre +
                '}';
    }
}
