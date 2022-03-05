package com.tt.back.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="NOMENCLATURE")
public class Nomenclature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private Long id;

    @Column(name="libelle", length=50, nullable=false)
    private String libelle;

    public Nomenclature() {
    }

    public Nomenclature(String libelle) {
        this.libelle = libelle;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nomenclature that = (Nomenclature) o;
        return Objects.equals(id, that.id) && Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
    }

    @Override
    public String toString() {
        return "Nomenclature{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}