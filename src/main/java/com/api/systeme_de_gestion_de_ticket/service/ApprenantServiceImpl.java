package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.systeme_de_gestion_de_ticket.modele.Apprenant;
import com.api.systeme_de_gestion_de_ticket.repository.ApprenantRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApprenantServiceImpl implements ApprenantService{

    private final ApprenantRepository apprenantRepository;

    @Override
    public Apprenant creer(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    @Override
    public Apprenant modifier(Long id, Apprenant apprenant) {
        Optional<Apprenant> optionalApprenant = apprenantRepository.findById(id);
        if (optionalApprenant.isPresent()) {

            Apprenant apprenantAmodifier = optionalApprenant.get();
            apprenantAmodifier.setNom(apprenant.getNom());
            apprenantAmodifier.setPrenom(apprenant.getPrenom());
            apprenantAmodifier.setEmail(apprenant.getEmail());

            return apprenantRepository.save(apprenantAmodifier);
        } else {

            return null;
        }
    }

    @Override
    public String supprimer(Long id) {
        apprenantRepository.deleteById(id);
        return "Apprenant supprimé avec succès";
    }

    @Override
    public List<Apprenant> afficher() {
        return apprenantRepository.findAll();
    }
    
}
