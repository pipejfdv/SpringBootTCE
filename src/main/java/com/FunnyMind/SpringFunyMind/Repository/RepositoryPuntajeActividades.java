package com.FunnyMind.SpringFunyMind.Repository;

import com.FunnyMind.SpringFunyMind.Entitys.PuntajeActividades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryPuntajeActividades extends JpaRepository<com.FunnyMind.SpringFunyMind.Entitys.PuntajeActividades, Integer> {
    //permite busar el id del usuario para agregar puntaje
    @Query("SELECT p FROM PuntajeActividades p WHERE p.id_usuario = :idUsuario")
    List<PuntajeActividades> findById_usuario(@Param("idUsuario") int idUsuario);

    //se crea para ayudar ajustar la categoria y el jugador
    @Query("SELECT p FROM PuntajeActividades p WHERE p.id_usuario = :idUsuario AND p.id_juego = :idJuego")
    Optional<PuntajeActividades> findById_usuarioAndIdJuego(@Param("idUsuario") int idUsuario, @Param("idJuego") int idJuego);

    @Query("SELECT p FROM PuntajeActividades p WHERE p.id_usuario = :idUsuario AND p.id_categoria = :idCategoria")
    Optional<PuntajeActividades> findById_usuarioAndId_Categoria(@Param("idUsuario") int idUsuario, @Param("idCategoria") int idCategoria);
}
