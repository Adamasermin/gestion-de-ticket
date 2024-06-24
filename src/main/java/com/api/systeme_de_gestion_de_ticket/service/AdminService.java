package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;
import com.api.systeme_de_gestion_de_ticket.modele.Administrateur;


public interface AdminService {
    Administrateur creer(Administrateur administrateur);

    Administrateur modifier(Long id, Administrateur administrateur);

    String supprimer(Long id);
    
    List<Administrateur> afficher();
}
