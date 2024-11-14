package com.FunnyMind.SpringFunyMind.Entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "sesiones")
public class Sesiones {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sesion;
    private int id_paciente;
    private int id_especialista;
    private LocalDate fecha_sesion;
    private int id_avance;
    private String info;
}
