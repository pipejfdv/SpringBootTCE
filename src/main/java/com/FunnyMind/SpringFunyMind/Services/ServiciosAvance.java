package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Repository.RepositoryAvance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosAvance {
    @Autowired
    private RepositoryAvance repositoryAvanceavance;

    //método que solo estará habilitado para (ADMIN)
    public List<com.FunnyMind.SpringFunyMind.Entitys.Avance> RegistrosAvances() {
        return repositoryAvanceavance.findAll();
    }
    //método que solo usuara cada (PSICOLOGO) en su cuenta propia
    public Optional<com.FunnyMind.SpringFunyMind.Entitys.Avance> RegistroAvance(int id) {
        return repositoryAvanceavance.findById(id);
    }
    //método que tendran solo los (PSICOLOGO)
    public void crearActualizarAvance(com.FunnyMind.SpringFunyMind.Entitys.Avance avance) {
        repositoryAvanceavance.save(avance);
    }
}
