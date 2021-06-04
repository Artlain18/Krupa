package com.example.Krupa.service;


import com.example.Krupa.models.game;
import com.example.Krupa.repo.gameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private gameRepository GameRepository;

    @Autowired
    public GameService(gameRepository GameRepository) {
        this.GameRepository = GameRepository;
    }
    public game addGame(String NAME) {
        game newGame = new game(NAME);
        return GameRepository.save(newGame);
    }
    public ArrayList<game> ReadGame(Integer GAME_ID) {
        Optional<game> game = GameRepository.findById(GAME_ID);
        ArrayList<game> readGame = new ArrayList<>();
        game.ifPresent(readGame::add);
        return readGame;
    }
    public List<game> AllGames() {
        //List<game> games = GameRepository.findAll();
        List<game> games = GameRepository.findAll();
        return games;
    }
    public game UpdateGame(game editGame, Integer GAME_ID) {
        game game = GameRepository.findById(GAME_ID).orElseThrow();
        game.setNAME(editGame.getNAME());
        game.setDESCRIBE(editGame.getDESCRIBE());
        game.setBACK(editGame.getBACK());
        game.setLOGO(editGame.getLOGO());
        game.setGAMETRAILER(editGame.getGAMETRAILER());
        game.setTEASER(editGame.getTEASER());
        game.setPUBLISHER(editGame.getPUBLISHER());
        GameRepository.save(game);
        return game;
    }
    public game UpdateGameWithBack(game editGame, Integer GAME_ID, String BACK) {
        game game = GameRepository.findById(GAME_ID).orElseThrow();
        game.setNAME(editGame.getNAME());
        game.setDESCRIBE(editGame.getDESCRIBE());
        game.setBACK(BACK);
        GameRepository.save(game);
        return game;
    }
    public void DeleteGame(Integer GAME_ID) {
        //game game = gameRepository.findById(GAME_ID).orElseThrow();
        GameRepository.delete(GameRepository.findById(GAME_ID).orElseThrow());
    }
    public game findBygameID (Integer GAME_ID) {

        return GameRepository.findBygameID(GAME_ID);
    }
}
