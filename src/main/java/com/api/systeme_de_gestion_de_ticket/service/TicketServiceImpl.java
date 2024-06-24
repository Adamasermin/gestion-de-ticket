package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.api.systeme_de_gestion_de_ticket.modele.Ticket;
import com.api.systeme_de_gestion_de_ticket.repository.TicketRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;

    private NotificationServiceImpl notificationServiceImpl;

    @Override
    public Ticket creer(Ticket ticket) {
      ticket.setEstRepondu(false);
       return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> afficher() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket modifier(Long id, Ticket ticket) {
       Optional<Ticket> optionalTicket = ticketRepository.findById(id);
       if (optionalTicket.isPresent()) {
            Ticket ticketAmodifier = optionalTicket.get();
            ticketAmodifier.setTitre(ticket.getTitre());
            ticketAmodifier.setStatus(ticket.getStatus());

            return ticketRepository.save(ticketAmodifier);
       } else {
        return null;
       }
    }

    @Override
    public String supprimer(Long id) {
       ticketRepository.deleteById(id);
       return "Ticket supprimé avec succès";
    }

    public Ticket repondreAuTicket(Long ticketId, String reponse) {
      Ticket ticket = ticketRepository.findById(ticketId)
              .orElseThrow(() -> new IllegalArgumentException("Invalid ticket ID"));

      // Logique pour répondre au ticket
      ticket.setEstRepondu(true);
      ticket.setReponse(reponse);
      // Ajouter la réponse au ticket, si nécessaire

      // Enregistrer le ticket mis à jour
      ticketRepository.save(ticket);

      // Envoyer une notification à l'apprenant
      notificationServiceImpl.envoyerNotification(ticket, "Votre ticket a été répondu : " + reponse);

      return ticket;
  }
    
}
