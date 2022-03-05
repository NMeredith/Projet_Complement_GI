package com.tt.back.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="PRODUIT")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private Long id;

    @Column(name="LIBELLE", length=50, nullable=false)
    private String libelle;

    @Column(name="EAN", length=12, nullable=false)
    private String ean;

    @Column(name="PRIX", length=10, scale = 2, nullable=false)
    private Float prix;

    @ManyToOne
    @JoinColumn(name="NOMENCLATURE_ID", nullable=false)
    private Nomenclature nomenclature;

    @Column(name="MARQUE", length=50, nullable=false)
    private String marque;

    @Column(name="FOURNISSEUR", length=50, nullable=false)
    private String fournisseur;

    @ManyToOne
    @JoinColumn(name="TVA_ID", nullable=false)
    private Tva tva;

    @Column(name="STOCK", length=10, nullable=false)
    private Integer stock;

    public Produit() {
    }

    public Long getId() {
        return id;
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

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
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

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Objects.equals(id, produit.id) && Objects.equals(libelle, produit.libelle) && Objects.equals(ean, produit.ean) && Objects.equals(prix, produit.prix) && Objects.equals(nomenclature, produit.nomenclature) && Objects.equals(marque, produit.marque) && Objects.equals(fournisseur, produit.fournisseur) && Objects.equals(tva, produit.tva) && Objects.equals(stock, produit.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, ean, prix, nomenclature, marque, fournisseur, tva, stock);
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", ean=" + ean +
                ", prix=" + prix +
                ", nomenclature=" + nomenclature +
                ", marque='" + marque + '\'' +
                ", fournisseur='" + fournisseur + '\'' +
                ", tva=" + tva +
                ", stock=" + stock +
                '}';
    }
}