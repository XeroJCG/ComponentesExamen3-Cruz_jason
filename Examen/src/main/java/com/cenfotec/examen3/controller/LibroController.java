package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.entities.Libro;
import com.cenfotec.examen3.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/libro"})
public class LibroController {

    @Autowired
    private LibroService service;


    @GetMapping(value = "/getLibrosByIdHijo/{idhijo}")
    public List getLibrosByiIdHijo(@PathVariable("idhijo") int idhijo) {
        return service.getLibrosByiIdHijo(idhijo);
    }


}
