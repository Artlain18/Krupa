package com.example.Krupa.repo;

import com.example.Krupa.models.game;
import com.example.Krupa.models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface gameRepository extends JpaRepository<game, Integer> {
    public game findBygameID(Integer GAME_ID);
}
