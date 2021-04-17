package com.example.Krupa.repo;

import com.example.Krupa.models.game;
import com.example.Krupa.models.gameLike;
import com.example.Krupa.models.reviewLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reviewLikeRepository extends JpaRepository<reviewLike, Integer> {
}
