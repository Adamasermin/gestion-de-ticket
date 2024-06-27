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
import com.api.systeme_de_gestion_de_ticket.modele.BaseDeConnaissance;
import com.api.systeme_de_gestion_de_ticket.service.BaseDeConnaissanceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "Base de connaissance", description = "Les différentes methodes concernant la base de connaissance")
@RequestMapping("/faq")
@AllArgsConstructor
public class BaseDeConnaissanceController {
    
    private final BaseDeConnaissanceService baseDeConnaissanceService;

    @Operation(summary = "Création", description = "Methodes faisant references a la création d'un questionnaire")
    @PostMapping("/creer")
    public BaseDeConnaissance create(@RequestBody BaseDeConnaissance baseDeConnaissance){
        return baseDeConnaissanceService.creer(baseDeConnaissance);
    }

    @Operation(summary = "Affichage", description = "Affichage de la FAQ")
    @GetMapping("/afficher")
    public List<BaseDeConnaissance> afficher(){
        return baseDeConnaissanceService.afficher();
    }

    @Operation(summary = "Modification", description = "Mise a jour de la FAQ")
    @PutMapping("/modifier/{id}")
    public BaseDeConnaissance modifier(@PathVariable Long id, @RequestBody BaseDeConnaissance baseDeConnaissance){
        return baseDeConnaissanceService.modifier(id, baseDeConnaissance);
    }

    @Operation(summary = "Suppression", description = "Suppression de la FAQ")
    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id){
        return baseDeConnaissanceService.supprimer(id);
    }
}
