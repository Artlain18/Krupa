package com.example.Krupa.repo;

import com.example.Krupa.models.game;
import com.example.Krupa.models.gameLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface gameLikeRepository extends JpaRepository<gameLike, Integer> {
}
