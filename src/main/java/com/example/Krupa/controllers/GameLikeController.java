package com.example.Krupa.controllers;


import com.example.Krupa.models.game;
import com.example.Krupa.models.users;
import com.example.Krupa.service.GameLikeService;
import com.example.Krupa.service.GameService;
import com.example.Krupa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameLikeController {
    @Autowired
    private GameLikeService gameLikeService;
    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;

    public GameLikeController(GameLikeService gameLikeService) {
        this.gameLikeService = gameLikeService;
    }
    @GetMapping("/gameLikes")
    public String getGameLikes(Model model) {
        model.addAttribute("gameLikes", gameLikeService.AllGamesLikes());
        return "gameLikes";
    }
    @GetMapping("/addGameLike")
    public String addGameLike(Model model) {
        return "addGameLike";
    }
    @PostMapping("/addGameLike")
    public String addGameLikesPost(@RequestParam Long USER_ID, @RequestParam Integer GAME_ID,  Model model) {
        users user = userService.findByuserID(USER_ID);
        game game = gameService.findBygameID(GAME_ID)   ;
        gameLikeService.addGameLikes(user, game);
        return "redirect:/gameLikes";
    }
}
