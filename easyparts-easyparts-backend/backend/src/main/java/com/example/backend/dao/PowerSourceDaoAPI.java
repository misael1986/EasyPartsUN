package com.example.backend.dao;

import com.example.backend.models.PowerSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerSourceDaoAPI extends JpaRepository<PowerSource,Long> {
}
