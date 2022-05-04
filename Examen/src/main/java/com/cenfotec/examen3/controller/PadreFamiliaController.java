package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.entities.PadreFamilia;
import com.cenfotec.examen3.services.PadreFamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/padrefamilia"})
public class PadreFamiliaController {

    @Autowired
    private PadreFamiliaService service;

    @GetMapping
    public List getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PadreFamilia> FindbyID(@PathVariable int id) {
        Optional<PadreFamilia> result = service.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PadreFamilia create(@RequestBody PadreFamilia padreFamilia) {
        return service.save(padreFamilia).get();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PadreFamilia> update(@PathVariable("id") int id,
                                               @RequestBody PadreFamilia padreFamilia) {
        padreFamilia.setCedula(id);
        Optional<PadreFamilia> result = service.update(padreFamilia);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (service.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/getPAdresFamiliabyName/{nombre}")
    public List getPAdresFamiliabyName(@PathVariable("nombre") String nombre) {
        return service.getPadresFamiliabyName(nombre);
    }

}
