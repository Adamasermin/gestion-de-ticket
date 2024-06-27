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

import com.api.systeme_de_gestion_de_ticket.modele.Apprenant;
import com.api.systeme_de_gestion_de_ticket.service.ApprenantService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "Apprenant", description = "Les différentes methodes concernant l'entité apprenant")
@RequestMapping("/apprenants")
@AllArgsConstructor
public class ApprenantController {

    private final ApprenantService apprenantService;

    @Operation(summary = "Création", description = "Methodes faisant references a la création d'un apprenant")
    @PostMapping("/creer")
    public Apprenant create(@RequestBody Apprenant apprenant){
        return apprenantService.creer(apprenant);
    }

    @Operation(summary = "Affichage", description = "Affichage des apprenants")
    @GetMapping("/afficher")
    public List<Apprenant> afficher(){
        return apprenantService.afficher();
    }

    @Operation(summary = "Modification", description = "Modification d'un apprenant")
    @PutMapping("/modifier/{id}")
    public Apprenant modifier(@PathVariable Long id, @RequestBody Apprenant apprenant){
        return apprenantService.modifier(id, apprenant);
    }

    @Operation(summary = "Suppression", description = "Suppression d'un apprenant")
    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id){
        return apprenantService.supprimer(id);
    }
}
