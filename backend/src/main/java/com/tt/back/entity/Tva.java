package com.tt.back.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="TVA")
public class Tva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private Long id;

    @Column(name="VALEUR", length=2, scale = 1, nullable=false)
    private Float valeur;

    @Column(name="LIBELLE", length=50, nullable=false)
    private String libelle;

    public Tva() {
    }

    public Tva(Float valeur, String libelle) {
        this.valeur = valeur;
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tva tva = (Tva) o;
        return Objects.equals(id, tva.id) && Objects.equals(valeur, tva.valeur) && Objects.equals(libelle, tva.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valeur, libelle);
    }

    @Override
    public String toString() {
        return "Tva{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}