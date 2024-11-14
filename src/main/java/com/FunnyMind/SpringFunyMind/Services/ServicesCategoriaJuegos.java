package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Entitys.CategoriaJuegos;
import com.FunnyMind.SpringFunyMind.Repository.RepositoryCategoriaJuegos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesCategoriaJuegos {
    @Autowired
    private RepositoryCategoriaJuegos repositoryCategoriaJuegos;

    public List<com.FunnyMind.SpringFunyMind.Entitys.CategoriaJuegos> categoriaJuegos() {
        return repositoryCategoriaJuegos.findAll();
    }

    //crear categoria de juegos (ADMIN)
    public void crearActualizarJuegos (CategoriaJuegos categoriaJuegos) {
        repositoryCategoriaJuegos.save(categoriaJuegos);
    }
    public void eliminarCategoriaJuegos (int id) {
        repositoryCategoriaJuegos.deleteById(id);
    }
}
