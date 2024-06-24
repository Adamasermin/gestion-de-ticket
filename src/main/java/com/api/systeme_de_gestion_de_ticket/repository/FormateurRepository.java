package com.api.systeme_de_gestion_de_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.systeme_de_gestion_de_ticket.modele.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long>{
    Formateur findByNom(String nom);
}
