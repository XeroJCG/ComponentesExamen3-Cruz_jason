package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.PadreFamilia;

import java.util.List;
import java.util.Optional;

public interface PadreFamiliaService {
    public List<PadreFamilia> getAll();

    public Optional<PadreFamilia> findById(int id);

    public Optional<PadreFamilia> save(PadreFamilia padreFamilia);

    public Optional<PadreFamilia> update(PadreFamilia padreFamilia);

    public boolean delete(int id);

    public List<PadreFamilia> getPadresFamiliabyName(String nombre);
}
