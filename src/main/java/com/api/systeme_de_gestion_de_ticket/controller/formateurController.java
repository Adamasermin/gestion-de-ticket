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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "Formateur", description = "Les différentes methodes concernant l'entité formateur")
@RequestMapping("/formateur")
@AllArgsConstructor
public class formateurController {
    private final FormateurService formateurService;

    @Operation(summary = "Création", description = "Methodes faisant references a la création d'un formateur")
    @PostMapping("/creer")
    public Formateur create(@RequestBody Formateur formateur){
        return formateurService.creer(formateur);
    }

    @Operation(summary = "Affichage", description = "Affichage des formateur")
    @GetMapping("/afficher")
    public List<Formateur> afficher(){
        return formateurService.afficher();
    }

    @Operation(summary = "Modification", description = "Modification des informations d'un formateur")
    @PutMapping("/modifier/{id}")
    public Formateur modifier(@PathVariable Long id, @RequestBody Formateur formateur){
        return formateurService.modifier(id, formateur);
    }

    @Operation(summary = "Suppression", description = "Suppression d'un formateur")
    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id){
        return formateurService.supprimer(id);
    }
}
