package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Entitys.Generos;
import com.FunnyMind.SpringFunyMind.Entitys.Usuarios;
import com.FunnyMind.SpringFunyMind.Repository.RepositoryGeneros;
import com.FunnyMind.SpringFunyMind.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesGeneros {
    //lista
    private List<Generos> generos;
    @Autowired
    private RepositoryGeneros repositoryGeneros;

    public List<com.FunnyMind.SpringFunyMind.Entitys.Generos> listaGeneros() {
        //variable que contiene la lista
        generos = new ArrayList<>(repositoryGeneros.findAll());
        return generos;
    }

    public void crearActualizarGeneros (Generos genero) {
        repositoryGeneros.save(genero);
    }
    public void eliminarGeneros (int id) {
        repositoryGeneros.deleteById(id);
    }
    //método para asignar valor de acuerdo al id_genero
    public String asignarGenero(Usuarios usuario) {
        if (usuario.getGenero_id() == 1){
            return  "Masculino";
        }
        else if (usuario.getGenero_id() == 2) {
            return  "Feminino";
        }
        else {
            return  "No definido";
        }
    }
}
