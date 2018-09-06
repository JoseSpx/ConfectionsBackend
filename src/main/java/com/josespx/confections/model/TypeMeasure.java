package com.josespx.confections.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "type_measure")
public class TypeMeasure {

    public interface Basic {}
    public interface Detail {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(Basic.class)
    private Long id;

    @Column(name = "name")
    @JsonView(Basic.class)
    private String name;

    @Column(name = "eliminated")
    @JsonView(Basic.class)
    private String eliminated;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "clothes_id")
    @JsonView(Detail.class)
    private Clothes clothes;

    @OneToMany(mappedBy = "typeMeasure", cascade = CascadeType.MERGE)
    @JsonView(Detail.class)
    private Set<Measure> measureSet = new HashSet<>();

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

    public Clothes getClothes() {
        return clothes;
    }

    @JsonIgnore
    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Set<Measure> getMeasureSet() {
        return measureSet;
    }

    @JsonIgnore
    public void setMeasureSet(Set<Measure> measureSet) {
        this.measureSet = measureSet;
    }
}




