package com.example.Krupa.repo;

import com.example.Krupa.models.game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface gameRepository extends JpaRepository<game, Integer> {
}
