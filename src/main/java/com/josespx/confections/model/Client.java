package com.josespx.confections.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private String address;
    private String phone1;
    private String phone2;

}
