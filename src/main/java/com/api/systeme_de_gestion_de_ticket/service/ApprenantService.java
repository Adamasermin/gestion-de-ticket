package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;

import com.api.systeme_de_gestion_de_ticket.modele.Apprenant;

public interface ApprenantService {

    Apprenant creer(Apprenant apprenant);

    Apprenant modifier(Long id, Apprenant apprenant);

    String supprimer(Long id);
    
    List<Apprenant> afficher();
    
}
