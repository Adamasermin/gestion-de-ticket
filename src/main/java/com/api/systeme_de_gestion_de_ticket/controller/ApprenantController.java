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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/apprenant")
@AllArgsConstructor
public class ApprenantController {

    private final ApprenantService apprenantService;

    @PostMapping("/creer")
    public Apprenant create(@RequestBody Apprenant apprenant){
        return apprenantService.creer(apprenant);
    }

    
    @GetMapping("/afficher")
    public List<Apprenant> afficher(){
        return apprenantService.afficher();
    }

    @PutMapping("/modifier/{id}")
    public Apprenant modifier(@PathVariable Long id, @RequestBody Apprenant apprenant){
        return apprenantService.modifier(id, apprenant);
    }

    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id){
        return apprenantService.supprimer(id);
    }
}
