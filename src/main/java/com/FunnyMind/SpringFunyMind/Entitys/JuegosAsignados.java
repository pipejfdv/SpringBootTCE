package com.FunnyMind.SpringFunyMind.Entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "juegos_asignados")
public class JuegosAsignados {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asignacion;
    private int id_juego;
    private LocalDate fecha_asignacion;
    private int id_paciente;
    private int id_especialista;
}
