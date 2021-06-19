package com.example.Krupa.controllers;
import com.example.Krupa.models.Role;
import com.example.Krupa.models.users;
import com.example.Krupa.repo.usersRepository;
import com.example.Krupa.repo.gameRepository;
import com.example.Krupa.service.GameService;
import com.example.Krupa.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.Collections;
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
    public String addUser(@ModelAttribute("user") users user, Model model) {
        return "addUsers";

    }
    @PostMapping("/addUsers")
    public String addUsersPost(@Valid @ModelAttribute("user") users user,   Model model) {
        user.setRoles(Collections.singleton(Role.USER));
        user.setIS_ADMIN(true);

        users userFromDB = usersRepository.findByNAME(user.getNAME());

        if (userFromDB != null) {
            model.addAttribute("message", "user exist");
            //model.addAttribute("roleList", roleList);
            //model.addAttribute("sellerList", sellerService.findAll());

            return "addUsers";
        }
        else {

            Userservice.addUsers(user);

            return "redirect:/";
        }
        //users newUser = usersRepository.findByNAME(user.getNAME().ToString());

        //return "redirect:/addUsers";
    }
    @PostMapping("/users/{id}/remove")
    public String addGamePostDelete(@PathVariable(value = "id") Long USER_ID, Model model) {
        Userservice.DeleteUser(USER_ID);
        return "redirect:/users";
    }
    @GetMapping("/user/{id}/edit")
    public String editUser(@PathVariable(value = "id") Long USER_ID, Model model) {
        model.addAttribute("readUser", Userservice.ReadUser(USER_ID));
        return "user-edit";
    }
    @PostMapping("/user/{id}/edit")
    public String addUserPostUpdate(@PathVariable(value = "id") Long USER_ID, @RequestParam String NAME, @RequestParam String PASSWORD, Model model) {
        Userservice.UpdateUser(USER_ID, NAME, PASSWORD);
        return "redirect:/users";
    }
    @GetMapping("/user/{id}")
    public String readUser(@PathVariable(value = "id") Long USER_ID, Model model) {
        model.addAttribute("readUser", Userservice.ReadUser(USER_ID));
        return "user-details";

    }



}
