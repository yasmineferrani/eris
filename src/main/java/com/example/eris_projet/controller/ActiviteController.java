package com.example.eris_projet.controller;

import com.example.eris_projet.entities.Activite;
import com.example.eris_projet.entities.Localisation;
import com.example.eris_projet.entities.Thematique;
import com.example.eris_projet.entities.Ville;
import com.example.eris_projet.service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
public class ActiviteController {
    @Autowired
    private ActiviteService service;

    @GetMapping("/villes")
    public String afficherVilles(Model model){
        List<Ville> listVilles = service.listAllVilles();
        model.addAttribute("listVilles",listVilles);
        return "ville";
    }

    @GetMapping("/rechercher/villes")
    public String rechercherUtilisateur(Model model, @Param("nomVille") String nomVille)
    {
        List<Ville> listVilles= service.rechercherVille(nomVille);

        model.addAttribute("listVilles",listVilles);
        return "ville";
    }

    @GetMapping("/activites")
    public String afficherActivite(Model model){
        List<Activite> listActivite = service.listAllActivite();
        List<Ville> listVilles= service.listAllVilles();
        List<Thematique> listThematique= service.listAllThematique();
        model.addAttribute("listThematique",listThematique);
        model.addAttribute("listVilles",listVilles);
        model.addAttribute("listActivite",listActivite);
        return "activite";
    }

    @GetMapping("/activites/{id}")
    public String afficherActiviteParVille(Model model,@PathVariable int id){
        List<Activite> listActivite = service.listActiviteByVille(id);
        List<Ville> listVilles= service.listAllVilles();
        model.addAttribute("listVilles",listVilles);
        model.addAttribute("listActivite",listActivite);
        return "activite";
    }


    @GetMapping("/activites/villes")
    public String afficherVillesActivite(Model model) {
        List<Ville> listVilles= service.listAllVilles();
        model.addAttribute("listVilles",listVilles);
        return "activite";
    }

    @GetMapping("/activites/thematique")
    public String afficherThematiqueActivite(Model model) {
        List<Thematique> listThematique= service.listAllThematique();
        model.addAttribute("listThematique",listThematique);
        return "activite";
    }

    @GetMapping("/administration")
    public String afficherFormulaireActivite(Model model) {
        List<Thematique> listThematique= service.listAllThematique();
        List<Ville> listVilles= service.listAllVilles();
        List<Localisation> listLocalisation = service.listAllLocalisation();
        Activite activite = new Activite();
        model.addAttribute("listThematique",listThematique);
        model.addAttribute("listLocalisation",listLocalisation);
        model.addAttribute("listVilles",listVilles);
        model.addAttribute("activite",activite);
        return "admin";
    }

    @GetMapping("/administration/save")
    public String ajouterActivite(Activite activite, RedirectAttributes redirectAttributes, @RequestParam("dateDebut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                                  @RequestParam("dateFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date2){
        activite.setDate_debut(date);
        activite.setDate_fin(date2);
        redirectAttributes.addFlashAttribute("message", "Le produit a été  ajouté avec succès.");
        service.save(activite);
        return "redirect:/accueil";
    }

    @GetMapping("/accueil")
    public String pageAccueil (){

        return "accueil";
    }

    @GetMapping("/activite/delete/{id}")
    public String deleteInscriptionActivite(@PathVariable int id, RedirectAttributes ra){
        service.delete(id);
        ra.addFlashAttribute("message", "Activité supprimé.");
        return "redirect:/accueil";
    }




}
