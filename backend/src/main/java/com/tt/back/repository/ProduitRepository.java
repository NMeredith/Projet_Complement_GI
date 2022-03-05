package com.tt.back.repository;

import com.tt.back.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    public List<Produit> findByLibelleIgnoreCaseContains(String libelle);
}