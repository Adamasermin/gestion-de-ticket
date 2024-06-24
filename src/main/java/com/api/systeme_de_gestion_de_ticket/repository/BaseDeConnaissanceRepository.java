package com.api.systeme_de_gestion_de_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.systeme_de_gestion_de_ticket.modele.BaseDeConnaissance;

public interface BaseDeConnaissanceRepository extends JpaRepository<BaseDeConnaissance, Long>{
    
}
