package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.systeme_de_gestion_de_ticket.modele.Formateur;
import com.api.systeme_de_gestion_de_ticket.repository.FormateurRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FormateurServiceImpl implements FormateurService{

    private final FormateurRepository formateurRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Formateur creer(Formateur formateur) {
        formateur.setPassword(passwordEncoder.encode(formateur.getPassword()));
        return formateurRepository.save(formateur);
    }

    @Override
    public Formateur modifier(Long id, Formateur formateur) {
        Optional<Formateur> optionalFormateur = formateurRepository.findById(id);
        if (optionalFormateur.isPresent()) {
            Formateur formateurAModifier = optionalFormateur.get();
            formateurAModifier.setNom(formateur.getNom());
            formateurAModifier.setPrenom(formateur.getPrenom());
            formateurAModifier.setEmail(formateur.getEmail());
            formateurAModifier.setNumero(formateur.getNumero());
            formateurAModifier.setPassword(passwordEncoder.encode(formateur.getPassword())); 
            return formateurRepository.save(formateurAModifier);
        } else {
            return null;
        }
    }

    @Override
    public String supprimer(Long id) {
        formateurRepository.deleteById(id);
        return "Formateur supprimé avec succès";
    }

    @Override
    public List<Formateur> afficher() {
        return formateurRepository.findAll();
    }
    
}
