package com.example.cert1alexcordero.entitites;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "libritos") //<- nombre q va en mongodb, que se supone q lo agrega solo

public class Libro{
    @Id
    private String id;

    private String Titulo;
    private String Autor;
    private String ISBN;
    private int Paginas;
    private String Categoria;
}
