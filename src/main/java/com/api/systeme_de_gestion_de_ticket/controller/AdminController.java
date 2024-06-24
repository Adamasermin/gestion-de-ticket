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

import com.api.systeme_de_gestion_de_ticket.modele.Administrateur;
//import com.api.systeme_de_gestion_de_ticket.service.AdminService;
import com.api.systeme_de_gestion_de_ticket.service.AdminServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminServiceImpl adminService;

    @PostMapping("/creer")
    public Administrateur create(@RequestBody Administrateur administrateur){
        return adminService.creer(administrateur);
    }

    @GetMapping("/afficher")
    public List<Administrateur> afficher(){
        return adminService.afficher();
    }

    @PutMapping("/modifier/{id}")
    public Administrateur modifier(@PathVariable Long id, @RequestBody Administrateur administrateur){
        return adminService.modifier(id, administrateur);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return adminService.supprimer(id);
    }
}
