package com.FunnyMind.SpringFunyMind.Entitys;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "juegos")
public class Juegos {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJuego;
    private String nombre;
    private String descripcion;
    private String id_categoriJuego;
}
