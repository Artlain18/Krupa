package com.example.Krupa.controllers;

import com.example.Krupa.models.game;
import com.example.Krupa.models.users;
import com.example.Krupa.repo.gameRepository;
import com.example.Krupa.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class GameController {
    private final GameService Gameservice;

    public GameController(GameService gameservice) {
        Gameservice = gameservice;
    }

    @GetMapping("/games")
    public String getGames(Model model) {
        //List<game> games = Gameservice.AllGames();

        model.addAttribute("games", Gameservice.AllGames());

        return "List_game";
        //return "error_end";
    }

    @GetMapping("/addGame")
    public String addGame(Model model) {
        return "addNewGame";

    }
    @PostMapping("/addGame")
    public String addGamePost(@RequestParam String NAME, Model model) {

        Gameservice.addGame(NAME);
        return "redirect:/games";
    }

    @GetMapping("/game/{id}")
    public String readGame(@PathVariable(value = "id") Integer GAME_ID, Model model) {
        /*if(Gameservice.findBygameID(GAME_ID)) {
            return "Error_classic";
        }*/

        //Optional<game> game = gameRepository.findById(GAME_ID);
        //game game = new game();
        //Optional<game> game = Gameservice.ReadGame(GAME_ID);
        //ArrayList<game> readGame = new ArrayList<>();
        //game.ifPresent(readGame::add);
        //ArrayList<game> readGame = Gameservice.ReadGame(GAME_ID);
        model.addAttribute("readGame", Gameservice.ReadGame(GAME_ID));
        return "game-details";

    }

    @GetMapping("/game/{id}/edit")
    public String editGame(@PathVariable(value = "id") Integer GAME_ID, Model model) {
        /*if(!gameRepository.existsById(GAME_ID)) {
            return "redirect:/error";
        }*/

        /*Optional<game> game = gameRepository.findById(GAME_ID);
        ArrayList<game> readGame = new ArrayList<>();
        game.ifPresent(readGame::add);*/
        model.addAttribute("readGame", Gameservice.ReadGame(GAME_ID));
        return "game-edit";

    }
    @GetMapping("game/{id}/edits")
    public String updateGamePostUpdate(@PathVariable(value = "id") Integer GAME_ID, Model model) {
        /*game game = gameRepository.findById(GAME_ID).orElseThrow();
        game.setNAME(NAME);
        gameRepository.save(game);*/
        game game = Gameservice.findBygameID(GAME_ID);
            model.addAttribute("readGame", game);
            return "game-edits";
        }
    @PostMapping("/update")
    public String addGamePostUpdate(@Valid game game, BindingResult bindingResult) {
        /*game game = gameRepository.findById(GAME_ID).orElseThrow();
        game.setNAME(NAME);
        gameRepository.save(game);*/

        Gameservice.UpdateGame(game, game.getGameID());
        return "redirect:/games";
    }

    @PostMapping("/game/{id}/remove")
    public String addGamePostDelete(@PathVariable(value = "id") Integer GAME_ID, Model model) {
        /*game game = gameRepository.findById(GAME_ID).orElseThrow();
        gameRepository.delete(gameRepository.findById(GAME_ID).orElseThrow());*/
        Gameservice.DeleteGame(GAME_ID);
        return "redirect:/games";
    }
    @GetMapping("/games/{id}/edit")
    public String ReadGame(@PathVariable(value = "id") Integer GAME_ID, Model model) {
        game game = Gameservice.findBygameID(GAME_ID);
        model.addAttribute("PUBLISHER", Gameservice.ReadGame(GAME_ID).get(0).getPUBLISHER());
        model.addAttribute("GAME_TRAILER", Gameservice.ReadGame(GAME_ID).get(0).getGAMETRAILER());
        model.addAttribute("gameBack", Gameservice.ReadGame(GAME_ID).get(0).getBACK());
        model.addAttribute("logo", Gameservice.ReadGame(GAME_ID).get(0).getLOGO());
        model.addAttribute("readGame", Gameservice.ReadGame(GAME_ID));
        return "game";
    }


}
