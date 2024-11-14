package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Repository.RepositorySesiones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesSesiones {
    @Autowired
    private RepositorySesiones repositorySesiones;

    private List<com.FunnyMind.SpringFunyMind.Entitys.Sesiones> sesionesList(){
        return repositorySesiones.findAll();
    }
    public Optional<com.FunnyMind.SpringFunyMind.Entitys.Sesiones> SesionesUsuario(int id){
        return repositorySesiones.findById(id);
    }
    public void crearActualizar(com.FunnyMind.SpringFunyMind.Entitys.Sesiones sesiones){
        repositorySesiones.save(sesiones);
    }
    public void eliminarSesion(int id){
        repositorySesiones.findById(id);
    }
}
