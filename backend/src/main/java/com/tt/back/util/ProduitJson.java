package com.tt.back.util;

public class ProduitJson {

    private String libelle;
    private String ean;
    private Long idNomenclature;
    private String marque;
    private String fournisseur;
    private Long idTva;
    private Integer stock;
    private Float prix;

    public ProduitJson() {
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public Long getIdNomenclature() {
        return idNomenclature;
    }

    public void setIdNomenclature(Long idNomenclature) {
        this.idNomenclature = idNomenclature;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Long getIdTva() {
        return idTva;
    }

    public void setIdTva(Long idTva) {
        this.idTva = idTva;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }
}
