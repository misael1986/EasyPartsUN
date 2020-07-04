package com.example.backend.dao;

import com.example.backend.models.Almacenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenamientoDaoAPI extends JpaRepository<Almacenamiento,Long> {
}
