package com.example.backend.dao;

import com.example.backend.models.Gabinete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GabineteDaoAPI extends JpaRepository<Gabinete,Long> {
}
