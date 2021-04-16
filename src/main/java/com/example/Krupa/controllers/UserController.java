package com.example.Krupa.controllers;
import com.example.Krupa.models.users;
import com.example.Krupa.repo.usersRepository;
import com.example.Krupa.repo.gameRepository;
import com.example.Krupa.service.GameService;
import com.example.Krupa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class UserController {
    private final UserService Userservice;
    @Autowired
    private com.example.Krupa.repo.usersRepository usersRepository;

    public UserController(UserService userservice) {
        Userservice = userservice;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", Userservice.AllUsers());
        return "users";
    }
    @GetMapping("/addUsers")
    public String addUser(Model model) {
        return "addUsers";

    }
    @PostMapping("/addUsers")
    public String addUsersPost(@RequestParam String NAME, @RequestParam String PASSWORD, @RequestParam boolean IS_ADMIN, Model model) {
        Userservice.addUsers(NAME, PASSWORD, IS_ADMIN);
        return "redirect:/users";
    }
    @PostMapping("/users/{id}/remove")
    public String addGamePostDelete(@PathVariable(value = "id") Integer USER_ID, Model model) {
        Userservice.DeleteUser(USER_ID);
        return "redirect:/users";
    }
    @GetMapping("/user/{id}/edit")
    public String editUser(@PathVariable(value = "id") Integer USER_ID, Model model) {
        model.addAttribute("readUser", Userservice.ReadUser(USER_ID));
        return "user-edit";
    }
    @PostMapping("/user/{id}/edit")
    public String addUserPostUpdate(@PathVariable(value = "id") Integer USER_ID, @RequestParam String NAME, @RequestParam String PASSWORD, Model model) {
        Userservice.UpdateUser(USER_ID, NAME, PASSWORD);
        return "redirect:/users";
    }
    @GetMapping("/user/{id}")
    public String readUser(@PathVariable(value = "id") Integer USER_ID, Model model) {
        model.addAttribute("readUser", Userservice.ReadUser(USER_ID));
        return "user-details";

    }



}
