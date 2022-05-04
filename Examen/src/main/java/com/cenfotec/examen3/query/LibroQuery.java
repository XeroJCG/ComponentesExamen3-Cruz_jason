package com.cenfotec.examen3.query;

import com.cenfotec.examen3.entities.Libro;
import com.cenfotec.examen3.services.LibroServiceImp;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LibroQuery implements GraphQLQueryResolver {

    @Autowired
    private LibroServiceImp serviceImp;

    public List<Libro> getLibros(int count) {
        return this.serviceImp.getAll(count).stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Libro> getLibro(int id) {
        return this.serviceImp.findById(id);
    }
}
