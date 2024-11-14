package com.FunnyMind.SpringFunyMind.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryJuegosAsignados extends JpaRepository<com.FunnyMind.SpringFunyMind.Entitys.JuegosAsignados, Integer> {
}
