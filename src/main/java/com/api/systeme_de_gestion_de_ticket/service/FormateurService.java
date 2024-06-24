package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;
import com.api.systeme_de_gestion_de_ticket.modele.Formateur;

public interface FormateurService {
    Formateur creer(Formateur formateur);

    Formateur modifier(Long id, Formateur formateur);

    String supprimer(Long id);
    
    List<Formateur> afficher();
}
