package com.FunnyMind.SpringFunyMind.Repository;

import com.FunnyMind.SpringFunyMind.Entitys.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryJuegos extends JpaRepository<com.FunnyMind.SpringFunyMind.Entitys.Juegos, Integer> {
    //obtener nombre de juego
    Optional<Juegos> findByIdJuego(int IdJuego);
}
