package com.api.systeme_de_gestion_de_ticket.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
public class Administrateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Integer numero;
    private String password;
    private String role = "ADMIN";
}
