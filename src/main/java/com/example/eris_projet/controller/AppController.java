package com.example.eris_projet.controller;

import com.example.eris_projet.entities.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String pageAccueil (Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "connexion";
    }

}
