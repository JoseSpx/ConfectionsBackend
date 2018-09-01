package com.josespx.confections.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clothes")
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "clothes", fetch = FetchType.EAGER)
    private Set<Measure> measureSet = new HashSet<>();

    public Clothes() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Measure> getMeasureSet() {
        return measureSet;
    }

    public void setMeasureList(Set<Measure> measureSet) {
        this.measureSet = measureSet;
    }
}
