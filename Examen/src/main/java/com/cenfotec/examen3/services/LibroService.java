package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    public List<Libro> getAll(int count);

    public Optional<Libro> findById(int id);

    public Optional<Libro> save(Libro libro);

    public Optional<Libro> update(Libro libro);

    public boolean delete(int id);

    public List<Libro> getLibrosByiIdHijo(int idHijo);
}
