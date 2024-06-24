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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/faq")
@AllArgsConstructor
public class BaseDeConnaissanceController {
    
    private final BaseDeConnaissanceService baseDeConnaissanceService;

    @PostMapping("/creer")
    public BaseDeConnaissance create(@RequestBody BaseDeConnaissance baseDeConnaissance){
        return baseDeConnaissanceService.creer(baseDeConnaissance);
    }

    @GetMapping("/afficher")
    public List<BaseDeConnaissance> afficher(){
        return baseDeConnaissanceService.afficher();
    }

    @PutMapping("/modifier/{id}")
    public BaseDeConnaissance modifier(@PathVariable Long id, @RequestBody BaseDeConnaissance baseDeConnaissance){
        return baseDeConnaissanceService.modifier(id, baseDeConnaissance);
    }

    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id){
        return baseDeConnaissanceService.supprimer(id);
    }
}
