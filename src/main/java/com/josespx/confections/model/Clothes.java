package com.josespx.confections.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
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

    @Column(name = "eliminated", columnDefinition = "char(1) default '0'")
    @JsonView(Clothes.Basic.class)
    private String eliminated;

    @OneToMany(mappedBy = "clothes", fetch = FetchType.EAGER)
    @JsonView(Clothes.Basic.class)
    private Set<TypeMeasure> typeMeasureSet = new HashSet<>();

    public Clothes(){}

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

    public Set<TypeMeasure> getTypeMeasureSet() {
        return typeMeasureSet;
    }

    @JsonIgnore
    public void setTypeMeasureSet(Set<TypeMeasure> typeMeasureSet) {
        this.typeMeasureSet = typeMeasureSet;
    }
}
