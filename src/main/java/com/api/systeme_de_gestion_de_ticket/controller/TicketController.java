package com.api.systeme_de_gestion_de_ticket.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.systeme_de_gestion_de_ticket.modele.Ticket;
import com.api.systeme_de_gestion_de_ticket.service.TicketService;
import com.api.systeme_de_gestion_de_ticket.service.TicketServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "Ticket", description = "Les différentes methodes concernant l'entité ticket")
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {
    
    private final TicketService ticketService;
    private final TicketServiceImpl ticketServiceImpl;

    @Operation(summary = "Création", description = "Methodes faisant references a la création d'un ticket par l'apprenant")
    @PostMapping("/creer")
    public Ticket create(@RequestBody Ticket ticket){
        return ticketService.creer(ticket);
    }

    @Operation(summary = "Affichage", description = "Affichage des tickets soumis")
    @GetMapping("/afficher")
    public List<Ticket> afficher(){
        return ticketService.afficher();
    }

    @Operation(summary = "Modification", description = "Modification des informations d'un ticket après la soumission")
    @PutMapping("/modifier/{id}")
    public Ticket modifier(@PathVariable Long id, @RequestBody Ticket ticket){
        return ticketService.modifier(id, ticket);
    }

    @Operation(summary = "Reponse", description = "Repondre a un ticket sounis exclusif au formateur")
    @PutMapping("/{id}/repondre")
    public ResponseEntity<?> repondreAuTicket(@PathVariable Long id, @RequestBody String reponse) {
        ticketServiceImpl.repondreAuTicket(id, reponse);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Suppression", description = "Suppression d'un ticket")
    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id){
        return ticketService.supprimer(id);
    }
}
