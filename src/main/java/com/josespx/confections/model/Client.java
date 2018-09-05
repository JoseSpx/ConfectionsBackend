package com.josespx.confections.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    public interface Basic {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(Client.Basic.class)
    private Long id;

    @Column(name = "name")
    @JsonView(Client.Basic.class)
    private String name;

    @Column(name = "lastname")
    @JsonView(Client.Basic.class)
    private String lastName;

    @Column(name = "dni", unique = true)
    @JsonView(Client.Basic.class)
    private String dni;

    @Column(name = "email")
    @JsonView(Client.Basic.class)
    private String email;

    @Column(name = "address")
    @JsonView(Client.Basic.class)
    private String address;

    @Column(name = "phone1")
    @JsonView(Client.Basic.class)
    private String phone1;

    @Column(name = "phone2")
    @JsonView(Client.Basic.class)
    private String phone2;

    @Column(name = "eliminated", columnDefinition = "char(1) default 0 ")
    private String eliminated;

    @OneToMany(mappedBy = "client")
    private Set<Order> orderList = new HashSet<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.MERGE)
    private Set<Measure> measureSet = new HashSet<>();

    public Client(){}

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEliminated() {
        return eliminated;
    }

    public void setEliminated(String eliminated) {
        this.eliminated = eliminated;
    }

    public Set<Order> getOrderList() {
        return orderList;
    }

    @JsonIgnore
    public void setOrderList(Set<Order> orderList) {
        this.orderList = orderList;
    }

    public Set<Measure> getMeasureSet() {
        return measureSet;
    }

    public void setMeasureSet(Set<Measure> measureSet) {
        this.measureSet = measureSet;
    }
}
