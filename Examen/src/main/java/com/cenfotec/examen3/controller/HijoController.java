package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.entities.Hijo;
import com.cenfotec.examen3.services.HijoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/hijo"})
public class HijoController {

    @Autowired
    private HijoService service;

    @GetMapping
    public List getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Hijo> FindbyID(@PathVariable int id) {
        Optional<Hijo> result = service.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Hijo create(@RequestBody Hijo hijo) {
        return service.save(hijo).get();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Hijo> update(@PathVariable("id") int id,
                                       @RequestBody Hijo hijo) {
        hijo.setId(id);
        Optional<Hijo> result = service.update(hijo);
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

    @GetMapping(value = "/getAllByFathersCedula/{cedula}")
    public List getAllByFathersCedula(@PathVariable("cedula") int cedula) {
        return this.service.getAllByFathersCedula(cedula);
    }

    @GetMapping(value = "/getCantLibrosLeidosByHijo")
    public List getCantLibrosLeidosByHijo() {
        return this.service.getCantLibrosLeidosByHijo();
    }


}
