package com.project.service;

import com.project.model.Inscription;
import com.project.model.InscriptionDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped 
public class InscriptionService {

    @PersistenceContext(unitName = "projectPU") 
    private EntityManager em; 

    @Inject 
    private Event<InscriptionEvent> evt; 

    @Transactional 
    public Inscription creer(InscriptionDTO dto) {
        Inscription ins = new Inscription();
        
        ins.setMatricule(dto.matricule()); // ← ajouté
        ins.setStatut(dto.statut());
        
        em.persist(ins); 

        evt.fire(new InscriptionEvent(dto.matricule()));
        
        return ins;
    }
}