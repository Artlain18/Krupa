package com.example.Krupa.controllers;

import com.example.Krupa.models.Role;
import com.example.Krupa.models.users;
import com.example.Krupa.repo.usersRepository;
import com.example.Krupa.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private usersRepository usersRepository;
    @Autowired
    private UserService usersService;
    @GetMapping("/registration")
    public String registration()
    {
        return "addUsers";
    }
    @PostMapping("/registration")
    public String addUser(@PathVariable(value = "NAME") String NAME, @PathVariable(value = "PASSWORD") String PASSWORD, Model model)
    {

        usersService.addUsers(NAME, PASSWORD, false);
        //users user = usersRepository.findByNAME(NAME);
        //user.setRoles(Collections.singleton(Role.USER));
        //return "redirect:/users";
        //usersService.addUsers(NAME, PASSWORD, true);
        //users user = usersRepository.findByNAME(NAME);
        /*users userFromDb = usersRepository.findByNAME(user.getNAME());
        if(userFromDb != null)
        {
            model.put("message", "User exists");
            return "addUsers";
        }*/
        //user.setIS_ADMIN(true);
        //user.setRoles(Collections.singleton(Role.USER));
        return "redirect:/login";
    }
}
