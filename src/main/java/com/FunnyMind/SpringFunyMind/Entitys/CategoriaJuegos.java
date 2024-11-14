package com.FunnyMind.SpringFunyMind.Entitys;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria_juegos")
public class CategoriaJuegos {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categori_juego;
    private String categoria;
}
