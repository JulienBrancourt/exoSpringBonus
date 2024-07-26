package org.example.exobonusspringforum.controller;

import org.example.exobonusspringforum.entity.Utilisateur;
import org.example.exobonusspringforum.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "accueil";
    }

    @GetMapping("/inscription")
    public String inscription(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "accueil";
    }

    @PostMapping("/inscription")
    public String inscription(@ModelAttribute Utilisateur utilisateur, Model model) {
        utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/";
    }
}
