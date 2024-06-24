package com.api.systeme_de_gestion_de_ticket.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.systeme_de_gestion_de_ticket.modele.Formateur;

import com.api.systeme_de_gestion_de_ticket.service.FormateurService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/formateur")
@AllArgsConstructor
public class formateurController {
    private final FormateurService formateurService;

    @PostMapping("/creer")
    public Formateur create(@RequestBody Formateur formateur){
        return formateurService.creer(formateur);
    }

    
    @GetMapping("/afficher")
    public List<Formateur> afficher(){
        return formateurService.afficher();
    }

    @PutMapping("/modifier/{id}")
    public Formateur modifier(@PathVariable Long id, @RequestBody Formateur formateur){
        return formateurService.modifier(id, formateur);
    }

    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id){
        return formateurService.supprimer(id);
    }
}
