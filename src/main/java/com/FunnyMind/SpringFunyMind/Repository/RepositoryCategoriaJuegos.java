package com.FunnyMind.SpringFunyMind.Repository;

import com.FunnyMind.SpringFunyMind.Entitys.CategoriaJuegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryCategoriaJuegos extends JpaRepository<com.FunnyMind.SpringFunyMind.Entitys.CategoriaJuegos, Integer> {
    @Query("SELECT c FROM CategoriaJuegos c WHERE c.id_categori_juego = :id")
    Optional<CategoriaJuegos> findByIdCategoriJuego(@Param("id") Integer id);

}
