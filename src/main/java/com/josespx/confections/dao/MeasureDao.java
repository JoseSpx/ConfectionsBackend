package com.josespx.confections.dao;

import com.josespx.confections.model.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasureDao extends JpaRepository<Measure, Long> {

    List<Measure> findAllByClientIdEquals(Long id);

}
