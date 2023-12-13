package com.example.eris_projet.controller;

import com.example.eris_projet.entities.Activite;
import com.example.eris_projet.entities.Client;
import com.example.eris_projet.entities.Inscription_Activite;
import com.example.eris_projet.service.ActiviteService;
import com.example.eris_projet.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Time;
import java.util.Date;
import java.util.List;
@Controller
public class InscriptionController {

    @Autowired
    ActiviteService service;

    @Autowired
    ClientService service2;
    @GetMapping("/inscriptionactivite/{id}")
    public String afficherInscriptionActivite(Model model, @PathVariable int id, HttpSession session){
        Inscription_Activite inscriptionActivite = new Inscription_Activite();
        Activite activite = service.findById(id);
        Client client = (Client) session.getAttribute("client");
        inscriptionActivite.setInfo_client(client);
        inscriptionActivite.setActivite(activite);
        model.addAttribute("inscriptionActivite",inscriptionActivite);
        return "inscription_activite";
    }

    @GetMapping("/inscriptionactivite/delete/{id}")
    public String deleteInscriptionActivite(@PathVariable int id, RedirectAttributes ra){
        service2.deleteIns(id);
        ra.addFlashAttribute("message", "The user ID" + id + " has been deleted.");
        return "redirect:/compte";
    }

    @GetMapping("/inscriptionactivite/edit/{id}")
    public String editInscriptionActivite(@PathVariable int id, Model model, RedirectAttributes ra, HttpSession session){
        Inscription_Activite inscriptionActivite = service2.get(id);
        Activite activite = service.findById(id);
        Client client = (Client) session.getAttribute("client");
        inscriptionActivite.setInfo_client(client);
        inscriptionActivite.setActivite(activite);
        model.addAttribute("inscriptionActivite",inscriptionActivite);
        ra.addFlashAttribute("message", "The user ID" + id + " has been deleted.");
        return "inscription_activite";
    }



    @PostMapping("/inscriptionactivite/save")
    public String inscrireActivite( Inscription_Activite inscriptionActivite, RedirectAttributes redirectAttributes, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date
                                    , HttpSession session){
        redirectAttributes.addFlashAttribute("message", "Inscription a été  ajouté avec succès.");
        Client client = (Client) session.getAttribute("client");
        inscriptionActivite.setInfo_client(client);
        inscriptionActivite.setDate(date);

        service2.save(inscriptionActivite);
        return "redirect:/compte";
    }

    @GetMapping("/compte")
    public String afficherInscriptionsClient(Model model, HttpSession session){
        Client client = (Client) session.getAttribute("client");
        List<Inscription_Activite> listeInscriptions = service2.listInscriptionsByClient(client.getClient_id());
        model.addAttribute("client", client);
        model.addAttribute("listeInscriptions",listeInscriptions);
        return "compte";
    }

    @PostMapping("/compte/save")
    public String clientSave( Client client, RedirectAttributes redirectAttributes, HttpServletRequest request){
        request.getSession().setAttribute("client", client);
        redirectAttributes.addFlashAttribute("message", "Client sauvegardé.");
        service2.save(client);
        return "redirect:/compte";
    }
}
