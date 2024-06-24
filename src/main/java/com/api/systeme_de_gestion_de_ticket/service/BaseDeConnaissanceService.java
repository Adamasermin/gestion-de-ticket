package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;

import com.api.systeme_de_gestion_de_ticket.modele.BaseDeConnaissance;


public interface BaseDeConnaissanceService {
    BaseDeConnaissance creer(BaseDeConnaissance BaseDeConnaissance);

    BaseDeConnaissance modifier(Long id, BaseDeConnaissance baseDeConnaissance);

    String supprimer(Long id);
    
    List<BaseDeConnaissance> afficher();
}
