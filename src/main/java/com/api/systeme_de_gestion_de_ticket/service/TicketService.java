package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;

import com.api.systeme_de_gestion_de_ticket.modele.Ticket;

public interface TicketService {
    
    Ticket creer(Ticket ticket);

    List<Ticket> afficher();

    Ticket modifier(Long id, Ticket ticket);

    String supprimer(Long id);

}
