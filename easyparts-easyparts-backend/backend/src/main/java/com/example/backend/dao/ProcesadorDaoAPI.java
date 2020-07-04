package com.example.backend.dao;

import com.example.backend.models.Procesador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcesadorDaoAPI extends JpaRepository<Procesador,Long> {
}