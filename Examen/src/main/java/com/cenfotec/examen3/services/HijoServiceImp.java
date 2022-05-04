package com.cenfotec.examen3.services;

import com.cenfotec.examen3.entities.Hijo;
import com.cenfotec.examen3.entities.Libro;
import com.cenfotec.examen3.repositories.HijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HijoServiceImp implements HijoService {

    @Autowired
    HijoRepository repository;

    @Autowired
    LibroServiceImp libroServiceImp;

    @Override
    public List<Hijo> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Hijo> findById(int id) {
        return this.repository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Hijo> save(Hijo hijo) {
        return Optional.of(repository.save(hijo));
    }

    @Override
    public Optional<Hijo> update(Hijo hijo) {
        Optional<Hijo> hijoBuscar = this.repository.findById(hijo.getId());
        if (hijoBuscar.isPresent()) {
            Hijo data = hijoBuscar.get();
            data.setNombre(hijo.getNombre());
            data.setTipoPlan(hijo.getTipoPlan());
            data.setCedulaPadre(hijo.getCedulaPadre());
            data.setAlergias(hijo.getAlergias());
            return Optional.of(repository.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {
        Optional<Hijo> hijoBuscar = this.repository.findById(id);
        if (hijoBuscar.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Hijo> getAllByFathersCedula(int cedula) {
        List<Hijo> hijos = this.repository.findAll();
        List<Hijo> hijosEncontrados = new ArrayList<>();
        for (Hijo h : hijos) {
            if (h.getCedulaPadre() == cedula) {
                hijosEncontrados.add(h);
            }
        }
        return hijosEncontrados;
    }

    @Override
    public List<String> getCantLibrosLeidosByHijo() {
        List<String> respuesta = new ArrayList<>();
        List<Hijo> hijos = this.repository.findAll();
        List<Libro> libros;

        String nombreHijo;
        long cantLibrosLeidos;

        for (Hijo h : hijos) {
            libros = libroServiceImp.getLibrosByiIdHijo(h.getId());
            nombreHijo = h.getNombre();
            cantLibrosLeidos = libros.stream().count();
            respuesta.add("{" +
                    "nombreHijo='" + nombreHijo + '\'' +
                    ", cantLibrosLeidos=" + cantLibrosLeidos +
                    '}');
        }

        return respuesta;
    }
}
