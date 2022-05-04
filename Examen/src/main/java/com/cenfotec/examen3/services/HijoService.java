package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.Hijo;

import java.util.List;
import java.util.Optional;

public interface HijoService {
    public List<Hijo> getAll();

    public Optional<Hijo> findById(int id);

    public Optional<Hijo> save(Hijo hijo);

    public Optional<Hijo> update(Hijo hijo);

    public boolean delete(int id);

    public List<Hijo> getAllByFathersCedula(int cedula);

    public List<String> getCantLibrosLeidosByHijo();
}
