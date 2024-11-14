package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Entitys.Juegos;
import com.FunnyMind.SpringFunyMind.Repository.RepositoryJuegos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesJuegos {
    @Autowired
    private RepositoryJuegos repositoryJuegos;

    public List<com.FunnyMind.SpringFunyMind.Entitys.Juegos> listaJuegos() {
        return repositoryJuegos.findAll();
    }
    public void crearActualizarJuegos(Juegos juego) {
        repositoryJuegos.save(juego);
    }
    public void eliminarJuegos(int id) {
        repositoryJuegos.deleteById(id);
    }
}
