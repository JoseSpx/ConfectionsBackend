package com.josespx.confections.dao;

import com.josespx.confections.model.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasureDao extends JpaRepository<Measure, Long> {

    List<Measure> findAllByClientIdEquals(Long id);
    List<Measure>
        findAllByClientIdAndTypeMeasureClothes_IdAndTypeMeasureEliminatedAndTypeMeasureClothesEliminated
            (Long idClient, Long idClothes, String tm_eliminated, String tmc_eliminated);

    // List<Measure> findAllByClient_IdAndTypeMeasure_Clothes_Id(Long idClient, Long idClothes);
    List<Measure> findAllByClient_IdAndTypeMeasure_Clothes_IdAndTypeMeasure_EliminatedAndTypeMeasure_Clothes_Eliminated
        (Long idClient, Long idClothes, String tm_eliminated, String tmc_eliminated);

}
