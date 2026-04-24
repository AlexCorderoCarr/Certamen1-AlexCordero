package com.example.cert1alexcordero.repositories;

import com.example.cert1alexcordero.entitites.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LibroRepo extends MongoRepository<Libro, String> {
    List<Libro> findByAutor(String autor);
    List<Libro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);

}
