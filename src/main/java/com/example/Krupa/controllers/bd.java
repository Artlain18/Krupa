package com.example.Krupa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bd {
    @RequestMapping("/greeting")
    public String cou(){
        return "vsem zdarova";
    }
}
