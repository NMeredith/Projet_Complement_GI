package com.tt.back.service;

import com.tt.back.entity.Nomenclature;
import com.tt.back.repository.NomenclatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomenclatureService {

    private NomenclatureRepository nomenclatureRepository;

    public NomenclatureService(NomenclatureRepository nomenclatureRepository) {
        this.nomenclatureRepository = nomenclatureRepository;
    }

    /**
     * Récupére l'ensemble des Nomenclatures
     * @return
     */
    public List<Nomenclature> getAll(){
        return nomenclatureRepository.findAll();
    }

    /**
     * Recherche une Nomenclature par son ID
     * @param id
     * @return
     */
    public Optional<Nomenclature> getById(Long id){
        return nomenclatureRepository.findById(id);
    }
}