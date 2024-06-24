package com.api.systeme_de_gestion_de_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.systeme_de_gestion_de_ticket.modele.Apprenant;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long>{
    Apprenant findByNom(String nom);
}