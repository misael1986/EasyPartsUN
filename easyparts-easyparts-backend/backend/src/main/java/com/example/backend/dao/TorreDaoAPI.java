package com.example.backend.dao;

import com.example.backend.models.Torre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorreDaoAPI extends JpaRepository<Torre,Long> {

}
