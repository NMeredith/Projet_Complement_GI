package com.tt.back.controller;

import com.tt.back.entity.Produit;
import com.tt.back.service.ProduitService;
import com.tt.back.util.ProduitJson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/produit")
public class ProduitController {

    private ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping(value = "/")
    public List<Produit> getAll(){
        return produitService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        Optional<Produit> produitOptional = produitService.getById(id);
        if(produitOptional.isPresent()){
            return new ResponseEntity<>(produitOptional.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Produit Introuvable", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/libelle/{libelle}")
    public List<Produit> getByLibelle(@PathVariable("libelle") String libelle){
        return produitService.getByLibelle(libelle);
    }

    @PostMapping(value = "/")
    public Produit create(@RequestBody ProduitJson produitJson){
        return produitService.create(produitJson);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProduitJson produitJson){
        Optional<Produit> produitOptional = produitService.getById(id);
        if(produitOptional.isPresent()){
            Produit updatedProduit = produitService.update(produitOptional.get(),produitJson);
            return new ResponseEntity<>(updatedProduit, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Produit Introuvable", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        Optional<Produit> produitOptional = produitService.getById(id);
        if(produitOptional.isPresent()){
            produitService.delete(produitOptional.get());
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Produit Introuvable", HttpStatus.NOT_FOUND);
        }
    }

}