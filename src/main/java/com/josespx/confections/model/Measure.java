package com.josespx.confections.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "measure")
public class Measure {

    public interface Basic {}
    public interface Detail {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(Measure.Basic.class)
    private Long id;

    @Column(name = "title")
    @JsonView(Measure.Basic.class)
    private String title;

    @Column(name = "comment")
    @JsonView(Measure.Basic.class)
    private String comment;

    @JsonView(Measure.Detail.class)
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonView(Measure.Detail.class)
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "clothes_id")

    private Clothes clothes;

    public Measure (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Client getClient() {
        return client;
    }

    @JsonIgnore
    public void setClient(Client client) {
        this.client = client;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

}
