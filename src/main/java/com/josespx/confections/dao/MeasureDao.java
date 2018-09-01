package com.josespx.confections.dao;

import com.josespx.confections.model.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasureDao extends JpaRepository<Measure, Long> {
}
