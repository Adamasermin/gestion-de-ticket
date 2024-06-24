package com.api.systeme_de_gestion_de_ticket.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.systeme_de_gestion_de_ticket.modele.Administrateur;
import com.api.systeme_de_gestion_de_ticket.modele.Apprenant;
import com.api.systeme_de_gestion_de_ticket.modele.Formateur;
import com.api.systeme_de_gestion_de_ticket.repository.AdministrateurRepository;
import com.api.systeme_de_gestion_de_ticket.repository.ApprenantRepository;
import com.api.systeme_de_gestion_de_ticket.repository.FormateurRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final AdministrateurRepository administrateurRepository;
    private final FormateurRepository formateurRepository;
    private final ApprenantRepository apprenantRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrateur admin = administrateurRepository.findByNom(username);
        if (admin != null) {
            return org.springframework.security.core.userdetails.User.withUsername(admin.getNom())
                .password(admin.getPassword())
                .roles(admin.getRole())
                .build();
        }

        Formateur formateur = formateurRepository.findByNom(username);
        if (formateur != null) {
            return org.springframework.security.core.userdetails.User.withUsername(formateur.getNom())
                .password(formateur.getPassword())
                .roles(formateur.getRole())
                .build();
        }

        Apprenant apprenant = apprenantRepository.findByNom(username);
        if (apprenant != null) {
            return org.springframework.security.core.userdetails.User.withUsername(apprenant.getNom())
                .password(apprenant.getPassword())
                .roles(apprenant.getRole())
                .build();
        }

        throw new UsernameNotFoundException("Utilisateur non trouvé");
    }
}
