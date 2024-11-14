package com.FunnyMind.SpringFunyMind.Entitys;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "generos")
public class Generos {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_genero;
    private String genero;
}
