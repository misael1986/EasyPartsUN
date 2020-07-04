package com.example.backend.dao;

import com.example.backend.models.MotherBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotherBoardDaoAPI extends JpaRepository<MotherBoard,Long> {
}
