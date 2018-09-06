package com.josespx.confections.dao;

import com.josespx.confections.model.TypeMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeMeasureDao extends JpaRepository<TypeMeasure, Long> {

    List<TypeMeasure> findAllByClothes_Id(Long id);
    List<TypeMeasure> findAllByClothes_IdAndEliminatedEqualsOrderByNameAsc(Long id, String eliminated);
    // List<TypeMeasure> findTypeMeasuresByClothes_Id(Long id);
    // TypeMeasure findTypeMeasuresByClothes_Id(Long id);
}
