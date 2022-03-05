package com.tt.back.repository;

import com.tt.back.entity.Nomenclature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NomenclatureRepository extends JpaRepository<Nomenclature, Long> {
}