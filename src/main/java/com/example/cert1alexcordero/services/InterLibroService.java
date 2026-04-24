package com.example.cert1alexcordero.services;

import com.example.cert1alexcordero.entitites.Libro;

import java.util.List;

public interface InterLibroService {
    Libro guardar(Libro libro);
    List<Libro> listarTodo(String buscar);
    List<Libro> buscarPorAutor(String autor);
}
