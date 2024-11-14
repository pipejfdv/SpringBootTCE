package com.FunnyMind.SpringFunyMind.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAvance extends JpaRepository<com.FunnyMind.SpringFunyMind.Entitys.Avance, Integer> {
}
