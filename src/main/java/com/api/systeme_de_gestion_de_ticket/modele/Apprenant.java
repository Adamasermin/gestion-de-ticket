package com.api.systeme_de_gestion_de_ticket.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "apprenant")
@Getter
@Setter
@NoArgsConstructor
public class Apprenant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Integer numero;
    private String password;
    private Integer niveauCompetence;
    private String role = "APPRENANT";

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Administrateur admin;
}
