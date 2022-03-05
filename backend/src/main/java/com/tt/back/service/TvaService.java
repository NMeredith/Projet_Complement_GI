package com.tt.back.service;

import com.tt.back.entity.Tva;
import com.tt.back.repository.TvaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TvaService {

    private TvaRepository tvaRepository;

    public TvaService(TvaRepository tvaRepository) {
        this.tvaRepository = tvaRepository;
    }

    /**
     * Récupére l'ensemble des TVA
     * @return
     */
    public List<Tva> getAll(){
        return tvaRepository.findAll();
    }

    /**
     * Recherche une TVA à partir de son ID
     * @param id
     * @return
     */
    public Optional<Tva> getById(Long id){
        return tvaRepository.findById(id);
    }
}