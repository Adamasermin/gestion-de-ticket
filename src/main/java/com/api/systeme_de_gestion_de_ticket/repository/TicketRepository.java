package com.api.systeme_de_gestion_de_ticket.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.systeme_de_gestion_de_ticket.modele.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
    
}
