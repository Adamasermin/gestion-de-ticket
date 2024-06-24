package com.api.systeme_de_gestion_de_ticket.modele;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notification")
@Getter
@Setter
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime dateEnvoi; 

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "apprenant_id", nullable = false)
    private Apprenant apprenant;

    @PrePersist
    protected void onCreate() {
        dateEnvoi = LocalDateTime.now();
    }
}
