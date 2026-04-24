package com.example.cert1alexcordero.controllers;

import com.example.cert1alexcordero.entitites.Libro;
import com.example.cert1alexcordero.services.InterLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")

public class LibroControlador {
    @Autowired
    private InterLibroService servicio;

    @GetMapping("/libros")
    public ResponseEntity<?> listarTodos(@RequestParam(required = false) String search) {
        try {
            List<Libro> libros = servicio.listarTodo(search);
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error al traer los libros");
        }
    }
    @PostMapping("/crearLibro")
    public ResponseEntity<?> guardar(@RequestBody Libro libro) {
        try {
            Libro nuevo = servicio.guardar(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/libros/{autor}") //el autor se coloca dentro de {}, ya q cmo en el pdf esta en :autor, pero no se si afecte sacar el {}, pero lo dejare porsiacaso según recomendacion de la ia
    public ResponseEntity<?> buscarPorAutor(@PathVariable String autor) {
        List<Libro> resultado = servicio.buscarPorAutor(autor);
        if (resultado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no hay libros de ese autor");
        }
        return ResponseEntity.ok(resultado);
    }
}


//en controller fue el ultimo package que edite, aqui si use bastante ia por el uso de sintaxis, no alcanze a usar el postman pero si conectaba usando el port 8080 y ver si el mongodb me conectaba
//pero igual hice la conexion en aplication.properties con el host de 27017