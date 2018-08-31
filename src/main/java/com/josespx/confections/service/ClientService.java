package com.josespx.confections.service;

import com.josespx.confections.dao.Dao;
import com.josespx.confections.model.Client;

import java.util.List;

public interface ClientService extends Dao<Client, Long> {

    @Override
    void save(Client client);

    @Override
    void deleteById(Long id);

    @Override
    List<Client> findAll();

    @Override
    Client findById(Long id);

    List<Client> findByDni(String dni);

    List<Client> findByLastname(String lastName);
}
