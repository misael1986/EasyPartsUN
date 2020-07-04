package com.example.backend.dao;

import com.example.backend.models.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RamDaoAPI extends JpaRepository<Ram,Long> {
}
