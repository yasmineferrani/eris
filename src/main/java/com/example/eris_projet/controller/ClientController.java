package com.example.eris_projet.controller;

import com.example.eris_projet.entities.Client;
import com.example.eris_projet.entities.ClientNotFoundException;
import com.example.eris_projet.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClientController {
    @Autowired
    ClientService service;

    @GetMapping("/connexion")
    public String pageConnexion(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "connexion";
    }
    @PostMapping("/connexion")
    public String connexion(Client client, HttpServletRequest request) throws ClientNotFoundException {
            Client clientConn = service.getByEmailPassword(client.getCourriel(), client.getPassword());
            request.getSession().setAttribute("client", clientConn);
            return "redirect:/accueil";
    }

    @GetMapping("/deconnexion")
    public String destroySession(HttpServletRequest request, HttpSession session) {
        Client client = (Client) session.getAttribute("client");
        request.getSession().invalidate();
        return "redirect:/connexion";
    }

    @GetMapping("/inscription")
    public String formulaireInscription(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("pageTitle", "Inscription");
        return "inscription";
    }

    @PostMapping("/inscription/save")
    public String ajouterUtilisateur(Client client) {
        client.setAdmin(false);
        service.save(client);
        return "redirect:/connexion";
    }







}
