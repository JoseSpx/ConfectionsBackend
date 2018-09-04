package com.josespx.confections.dao;

import com.josespx.confections.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDao extends JpaRepository<Client, Long> {

    List<Client> findByDniEquals(String dni);
    List<Client> findByLastNameContains(String lastName);
    List<Client> findAllByEliminatedEquals(String eliminated);

}
