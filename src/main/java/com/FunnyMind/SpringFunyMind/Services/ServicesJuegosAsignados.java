package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Repository.RepositoryJuegosAsignados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesJuegosAsignados {
    @Autowired
    private RepositoryJuegosAsignados repositoryJuegosAsignados;

    //Acceso a registro para los (PSICOLOGOS & ADMIN)
    public List<com.FunnyMind.SpringFunyMind.Entitys.JuegosAsignados> listaJuegosAsignados() {
        return repositoryJuegosAsignados.findAll();
    }

    public Optional<com.FunnyMind.SpringFunyMind.Entitys.JuegosAsignados> juegosAsignadosUsuario(int id){
        return repositoryJuegosAsignados.findById(id);
    }

    public void crearActualizarJuegoAsignado (com.FunnyMind.SpringFunyMind.Entitys.JuegosAsignados juegoAsignado){
        repositoryJuegosAsignados.save(juegoAsignado);
    }
    //no se relaciona el método eliminar para perder registros
}
