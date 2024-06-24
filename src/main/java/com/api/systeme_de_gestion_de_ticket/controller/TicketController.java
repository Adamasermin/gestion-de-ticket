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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {
    
    private final TicketService ticketService;
    private final TicketServiceImpl ticketServiceImpl;

    @PostMapping("/creer")
    public Ticket create(@RequestBody Ticket ticket){
        return ticketService.creer(ticket);
    }

    @GetMapping("/afficher")
    public List<Ticket> afficher(){
        return ticketService.afficher();
    }

    @PutMapping("/modifier/{id}")
    public Ticket modifier(@PathVariable Long id, @RequestBody Ticket ticket){
        return ticketService.modifier(id, ticket);
    }

    @PutMapping("/{id}/repondre")
    public ResponseEntity<?> repondreAuTicket(@PathVariable Long id, @RequestBody String reponse) {
        ticketServiceImpl.repondreAuTicket(id, reponse);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id){
        return ticketService.supprimer(id);
    }
}
