package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Entitys.Especialidad;
import com.FunnyMind.SpringFunyMind.Repository.RepositoryEspecialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesEspecialidad {
    @Autowired
    private RepositoryEspecialidad repositoryEspecialidad;

    //metodo para clasificar los medicos especialistas para (ADMIN)
    public List<com.FunnyMind.SpringFunyMind.Entitys.Especialidad> listaEspecialidad(){
        return repositoryEspecialidad.findAll();
    }

    public void crearActualicarEspecialidad(Especialidad especialidad){
        repositoryEspecialidad.save(especialidad);
    }
    public void eliminarEspecialidad(int id){
        repositoryEspecialidad.deleteById(id);
    }
}
