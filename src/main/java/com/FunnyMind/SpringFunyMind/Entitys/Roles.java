package com.FunnyMind.SpringFunyMind.Entitys;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Roles {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;
    private String rol;
}
