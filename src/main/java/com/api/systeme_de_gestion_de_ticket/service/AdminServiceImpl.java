package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.systeme_de_gestion_de_ticket.modele.Administrateur;
import com.api.systeme_de_gestion_de_ticket.repository.AdministrateurRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdministrateurRepository administrateurRepository;
    private final PasswordEncoder passwordEncoder; 

    @Override
    public Administrateur creer(Administrateur administrateur) {
        administrateur.setPassword(passwordEncoder.encode(administrateur.getPassword()));
        return administrateurRepository.save(administrateur);
    }

    @Override
    public Administrateur modifier(Long id, Administrateur administrateur) {
        Optional<Administrateur> optionalAdmin = administrateurRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Administrateur adminAModifier = optionalAdmin.get();
            adminAModifier.setNom(administrateur.getNom());
            adminAModifier.setPrenom(administrateur.getPrenom());
            adminAModifier.setEmail(administrateur.getEmail());
            adminAModifier.setNumero(administrateur.getNumero());
            adminAModifier.setPassword(passwordEncoder.encode(administrateur.getPassword())); 
            return administrateurRepository.save(adminAModifier);
        } else {
            return null;
        }
    }

    @Override
    public String supprimer(Long id) {
        administrateurRepository.deleteById(id);
        return "Admin supprimé avec succès";
    }

    @Override
    public List<Administrateur> afficher() {
       return administrateurRepository.findAll();
    }
    
}
