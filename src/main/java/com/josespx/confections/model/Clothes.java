package com.josespx.confections.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clothes")
public class Clothes {

    public interface Basic {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(Clothes.Basic.class)
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonView(Clothes.Basic.class)
    private String name;

    @NotNull
    @Column(name = "eliminated", columnDefinition = "char(1) default '0'")
    private String eliminated;

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

    public String getEliminated() {
        return eliminated;
    }

    public void setEliminated(String eliminated) {
        this.eliminated = eliminated;
    }

    public void setMeasureSet(Set<Measure> measureSet) {
        this.measureSet = measureSet;
    }

    public Set<Measure> getMeasureSet() {
        return measureSet;
    }
}
