package com.example.Krupa.controllers;

import com.example.Krupa.models.game;
import com.example.Krupa.repo.gameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class GameController {

    @Autowired
    private gameRepository gameRepository;
    @GetMapping("/games")
    public String getGames(Model model) {
        List<game> games = gameRepository.findAll();
        model.addAttribute("games", games);
        return "games";

    }

    @GetMapping("/addGame")
    public String addGame(Model model) {
        return "addGame";

    }
    @PostMapping("/addGame")
    public String addGamePost(@RequestParam String NAME, Model model) {
        game game = new game(NAME);
        gameRepository.save(game);
        return "redirect:/games";
    }

    @GetMapping("/game/{id}")
    public String readGame(@PathVariable(value = "id") Integer GAME_ID, Model model) {
        /*if(!gameRepository.existsById(GAME_ID)) {
            return "redirect:/error";
        }*/

        Optional<game> game = gameRepository.findById(GAME_ID);
        ArrayList<game> readGame = new ArrayList<>();
        game.ifPresent(readGame::add);
        model.addAttribute("readGame", readGame);
        return "game-details";

    }

    @GetMapping("/game/{id}/edit")
    public String editGame(@PathVariable(value = "id") Integer GAME_ID, Model model) {
        /*if(!gameRepository.existsById(GAME_ID)) {
            return "redirect:/error";
        }*/

        Optional<game> game = gameRepository.findById(GAME_ID);
        ArrayList<game> readGame = new ArrayList<>();
        game.ifPresent(readGame::add);
        model.addAttribute("readGame", readGame);
        return "game-edit";

    }

    @PostMapping("/game/{id}/edit")
    public String addGamePostUpdate(@PathVariable(value = "id") Integer GAME_ID, @RequestParam String NAME, Model model) {
        game game = gameRepository.findById(GAME_ID).orElseThrow();
        game.setNAME(NAME);
        gameRepository.save(game);
        return "redirect:/games";
    }

    @PostMapping("/game/{id}/remove")
    public String addGamePostDelete(@PathVariable(value = "id") Integer GAME_ID, Model model) {
        game game = gameRepository.findById(GAME_ID).orElseThrow();
        gameRepository.delete(gameRepository.findById(GAME_ID).orElseThrow());
        return "redirect:/games";
    }


}
