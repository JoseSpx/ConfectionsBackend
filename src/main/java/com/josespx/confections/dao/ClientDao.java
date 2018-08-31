package com.josespx.confections.dao;

import com.josespx.confections.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {

    Client findByDniEquals(String dni);

}
