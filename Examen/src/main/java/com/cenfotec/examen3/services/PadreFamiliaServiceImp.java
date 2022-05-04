package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.PadreFamilia;
import com.cenfotec.examen3.helpers.Helper;
import com.cenfotec.examen3.repositories.PadreFamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PadreFamiliaServiceImp implements PadreFamiliaService {

    @Autowired
    PadreFamiliaRepository repository;


    @Override
    public List<PadreFamilia> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<PadreFamilia> findById(int id) {
        return repository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<PadreFamilia> save(PadreFamilia padreFamilia) {
        return Optional.of(repository.save(padreFamilia));
    }

    @Override
    public Optional<PadreFamilia> update(PadreFamilia padreFamilia) {
        Optional<PadreFamilia> PadreFamiliaBuscar = this.repository.findById(padreFamilia.getCedula());
        if (PadreFamiliaBuscar.isPresent()) {
            PadreFamilia data = PadreFamiliaBuscar.get();
            data.setCedula(padreFamilia.getCedula());
            data.setNombre(padreFamilia.getNombre());
            data.setDireccion(padreFamilia.getDireccion());
            data.setTelefono1(padreFamilia.getTelefono1());
            data.setTelefono2(padreFamilia.getTelefono2());
            return Optional.of(repository.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {
        Optional<PadreFamilia> PadreFamiliaBuscar = this.repository.findById(id);
        if (PadreFamiliaBuscar.isPresent()) {
            this.repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<PadreFamilia> getPadresFamiliabyName(String nombre) {
        List<PadreFamilia> padresFamilia = this.repository.findAll();
        List<PadreFamilia> encontrados = new ArrayList<>();
        for (PadreFamilia p : padresFamilia) {
            if (Helper.like(p.getNombre(), "%" + nombre + "%")) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }
}
