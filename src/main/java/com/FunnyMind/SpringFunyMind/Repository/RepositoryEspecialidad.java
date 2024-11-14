package com.FunnyMind.SpringFunyMind.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEspecialidad extends JpaRepository<com.FunnyMind.SpringFunyMind.Entitys.Especialidad, Integer> {
}
