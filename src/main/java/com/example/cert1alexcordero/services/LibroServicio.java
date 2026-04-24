package com.example.cert1alexcordero.services;

import com.example.cert1alexcordero.entitites.Libro;
import com.example.cert1alexcordero.repositories.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicio implements InterLibroService {

    @Autowired
    private LibroRepo repo;

    @Override
    public Libro guardar(Libro libro){
        if (libro.getISBN() == null || libro.getISBN().length() != 13) {
            throw new RuntimeException("El isbn tiene q ser de 13");
        }
        if (libro.getPaginas() <= 10) {
            throw new RuntimeException("muy pocas paginas, minimo 11");
        }
        return repo.save(libro);
    }
    public List<Libro> listarTodo(String buscar){
        if (buscar != null && !buscar.isEmpty()){
            return repo.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(buscar, buscar);
        }
        return repo.findAll();
        }
    @Override
    public List<Libro> buscarPorAutor(String autor) {
        return repo.findByAutor(autor);
    }
}
