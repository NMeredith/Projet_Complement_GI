package com.tt.back.service;

import com.tt.back.entity.Produit;
import com.tt.back.repository.ProduitRepository;
import com.tt.back.util.ProduitJson;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private ProduitRepository produitRepository;

    private NomenclatureService nomenclatureService;

    private TvaService tvaService;

    public ProduitService(ProduitRepository produitRepository, NomenclatureService nomenclatureService, TvaService tvaService) {
        this.produitRepository = produitRepository;
        this.nomenclatureService = nomenclatureService;
        this.tvaService = tvaService;
    }

    /**
     * Récupére l'ensemble des Produits
     * @return
     */
    public List<Produit> getAll(){
        return produitRepository.findAll();
    }

    /**
     * Recherche un Produit par son ID
     * @param id
     * @return
     */
    public Optional<Produit> getById(Long id){
        return produitRepository.findById(id);
    }

    /**
     * Recherche des Produits à partir d'un libelle
     * @param libelle
     * @return
     */
    public List<Produit> getByLibelle(String libelle){
        return produitRepository.findByLibelleIgnoreCaseContains(libelle);
    }

    /**
     * Fonction pour copier l'objet issu du request body dans un produit
     * @param produitJson
     * @param produit
     * @return
     */
    private Produit copyProduitJsonIntoProduit(ProduitJson produitJson, Produit produit){

        // Récupération de la nomenclature
        nomenclatureService.getById(produitJson.getIdNomenclature()).ifPresent(produit::setNomenclature);

        // Récupération de la tva
        tvaService.getById(produitJson.getIdTva()).ifPresent(produit::setTva);

        produit.setFournisseur(produitJson.getFournisseur());
        produit.setLibelle(produitJson.getLibelle());
        produit.setEan(produitJson.getEan());
        produit.setMarque(produitJson.getMarque());
        produit.setStock(produitJson.getStock());
        produit.setPrix(produitJson.getPrix());

        return produitRepository.save(produit);
    }

    /**
     * Création d'un nouveau Produit
     * @param produitJson
     * @return
     */
    public Produit create(ProduitJson produitJson){
        return copyProduitJsonIntoProduit(produitJson, new Produit());
    }

    /**
     * Mise à jour d'un Produit
     * @param produitFromDb
     * @param produitJson
     * @return
     */
    public Produit update(Produit produitFromDb, ProduitJson produitJson){
        return copyProduitJsonIntoProduit(produitJson, produitFromDb);
    }

    /**
     * Supprime un produit
     * @param produit
     */
    public void delete(Produit produit){
        produitRepository.delete(produit);
    }
}