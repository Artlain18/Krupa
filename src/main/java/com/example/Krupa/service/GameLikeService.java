package com.example.Krupa.service;

import com.example.Krupa.models.game;
import com.example.Krupa.models.gameLike;
import com.example.Krupa.models.routeGameLike;
import com.example.Krupa.models.users;
import com.example.Krupa.repo.gameLikeRepository;
import com.example.Krupa.repo.gameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameLikeService {

    private gameLikeRepository GameLikeRepository;

    @Autowired
    public GameLikeService(gameLikeRepository GameLikeRepository) {
        this.GameLikeRepository = GameLikeRepository;
    }

    public List<gameLike> AllGamesLikes() {
        List<gameLike> gameLikes = GameLikeRepository.findAll();
        return gameLikes;
    }
    public gameLike addGameLikes(users USER_ID, game GAME_ID) {
        gameLike newGameLike = new gameLike(USER_ID, GAME_ID);
        newGameLike.setUSER_ID(USER_ID);
        newGameLike.setGAME_ID(GAME_ID);
        newGameLike.setIS_GAME_LIKE(true);
        routeGameLike route = new routeGameLike(USER_ID.getUserID(), GAME_ID.getGameID());
        newGameLike.setId(route);
        return GameLikeRepository.save(newGameLike);
    }
}
