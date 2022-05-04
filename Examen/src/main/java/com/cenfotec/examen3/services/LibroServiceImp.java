package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.Libro;
import com.cenfotec.examen3.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroServiceImp implements LibroService {

    @Autowired
    LibroRepository repository;

    @Override
    public List<Libro> getAll(int count) {
        List<Libro> libros = this.repository.findAll().stream().limit(count).collect(Collectors.toList());
        List<Libro> response = new ArrayList<>();
        for (Libro l :
                libros) {
            if (l.isEstado()) {
                response.add(l);
            }
        }
        return response;
    }

    @Override
    public Optional<Libro> findById(int id) {
        return this.repository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Libro> save(Libro libro) {
        return Optional.of(repository.save(libro));
    }

    @Override
    public Optional<Libro> update(Libro libro) {
        Optional<Libro> libroBuscar = this.repository.findById(libro.getId());
        Optional<Libro> response = null;
        if (libroBuscar.isPresent()) {
            Libro data = libroBuscar.get();
            data.setNombre(libro.getNombre());
            data.setIdhijo(libro.getIdhijo());
            response = Optional.of(this.repository.save(data));
            return response;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {
        Optional<Libro> libroBuscar = this.repository.findById(id);
        if (libroBuscar.isPresent()) {
            Libro data = libroBuscar.get();
            data.setEstado(false);
            repository.save(data);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Libro> getLibrosByiIdHijo(int idHijo) {
        List<Libro> libros = this.repository.findAll();
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getIdhijo() == idHijo) {
                librosEncontrados.add(l);
            }
        }
        return librosEncontrados;
    }
}
