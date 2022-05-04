package com.cenfotec.examen3.mutation;

import com.cenfotec.examen3.entities.Libro;
import com.cenfotec.examen3.services.LibroServiceImp;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LibroMutation implements GraphQLMutationResolver {

    @Autowired
    private LibroServiceImp serviceImp;

    public Libro crearLibro(int idhijo, String nombre) {

        Libro nuevoLibro = new Libro();
        nuevoLibro.setNombre(nombre);
        nuevoLibro.setIdhijo(idhijo);
        nuevoLibro.setEstado(true);
        return this.serviceImp.save(nuevoLibro).get();
    }

    public Libro actualizarLibro(int id, int idJHijo, String nombre) {
        Optional<Libro> libroBuscar = this.serviceImp.findById(id);

        Libro data = null;
        if (libroBuscar.isPresent()) {
            data = libroBuscar.get();
            data.setNombre(nombre);
            data.setIdhijo(idJHijo);
            return serviceImp.update(data).get();
        }
        return data;
    }

    public boolean borrarLibro(int id) {
        Optional<Libro> libroBuscar = this.serviceImp.findById(id);
        if (libroBuscar.isPresent()) {
            Libro data = libroBuscar.get();
            data.setEstado(false);
            serviceImp.delete(id);
            return true;
        }
        return false;
    }
}
