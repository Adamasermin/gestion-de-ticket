package com.api.systeme_de_gestion_de_ticket.service;

import java.util.List;
import java.util.Optional;
import com.api.systeme_de_gestion_de_ticket.modele.BaseDeConnaissance;
import com.api.systeme_de_gestion_de_ticket.repository.BaseDeConnaissanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BaseDeConnaissanceServiceImpl implements BaseDeConnaissanceService{

    private final BaseDeConnaissanceRepository baseDeConnaissanceRepository;

    @Override
    public BaseDeConnaissance creer(BaseDeConnaissance baseDeConnaissance) {
        return baseDeConnaissanceRepository.save(baseDeConnaissance);
    }

    @Override
    public BaseDeConnaissance modifier(Long id, BaseDeConnaissance baseDeConnaissance) {
       Optional<BaseDeConnaissance> optionalBase = baseDeConnaissanceRepository.findById(id);
        if (optionalBase.isPresent()) {

            BaseDeConnaissance baseAmodifier = optionalBase.get();
            baseAmodifier.setTitre(baseDeConnaissance.getTitre());
            baseAmodifier.setContenu(baseDeConnaissance.getContenu());
            return baseDeConnaissanceRepository.save(baseAmodifier);
        } else {
            return null;
        }
    }

    @Override
    public String supprimer(Long id) {
        baseDeConnaissanceRepository.deleteById(id);
        return "Question supprimé avec succès";
    }

    @Override
    public List<BaseDeConnaissance> afficher() {
        return baseDeConnaissanceRepository.findAll();
    }
    
}
