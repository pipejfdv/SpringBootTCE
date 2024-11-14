package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Repository.RepositoryRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesRoles {
    @Autowired
    private RepositoryRoles repositoryRoles;

    public List<com.FunnyMind.SpringFunyMind.Entitys.Roles> listaRoles() {
        return repositoryRoles.findAll();
    }
    public Optional<com.FunnyMind.SpringFunyMind.Entitys.Roles> Rol(int id) {
        return repositoryRoles.findById(id);
    }

    public void crearActualizar(com.FunnyMind.SpringFunyMind.Entitys.Roles roles) {
        repositoryRoles.save(roles);
    }
    public void eliminarActualizar(int id) {
        repositoryRoles.deleteById(id);
    }
}
