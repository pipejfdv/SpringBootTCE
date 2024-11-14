package com.FunnyMind.SpringFunyMind.Repository;

import com.FunnyMind.SpringFunyMind.Entitys.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<com.FunnyMind.SpringFunyMind.Entitys.Usuarios, Integer> {
    //se podra agregar los otros métodos que requiera el usuario
    Usuarios findByUsername(String username);
}
