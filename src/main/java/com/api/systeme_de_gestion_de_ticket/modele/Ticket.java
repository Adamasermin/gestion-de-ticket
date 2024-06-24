package com.api.systeme_de_gestion_de_ticket.modele;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String status;
    private Boolean estRepondu;
    private String reponse;

    @ManyToOne
    @JoinColumn(name = "apprenant_id", nullable = false)
    private Apprenant apprenant;

    @ManyToOne
    @JoinColumn(name = "formateur_id", nullable = false)
    private Formateur formateur;

    @OneToMany(mappedBy = "ticket")
    private List<Notification> notifications;
}
