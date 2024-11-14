package com.FunnyMind.SpringFunyMind.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "avance")
public class Avance {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_avance;
    private String avance;
    @NotBlank
    private int id_paciente;
    @NotBlank
    private int id_especialista;
}
