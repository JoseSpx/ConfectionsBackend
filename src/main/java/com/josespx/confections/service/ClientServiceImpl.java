package com.josespx.confections.service;

import com.josespx.confections.dao.ClientDao;
import com.josespx.confections.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    @Autowired
    public ClientServiceImpl( ClientDao clientDao ){
        this.clientDao = clientDao;
    }

    @Override
    public void save(Client client) {
        this.clientDao.save(client);
    }

    @Override
    public void deleteById(Long id) {
        this.clientDao.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return this.clientDao.findAll();
    }

    @Override
    public Client findById(Long id) {
        return this.clientDao.findById(id).orElse(null);
    }

    @Override
    public List<Client> findByDni(String dni) {
        return this.clientDao.findByDniEquals(dni);
    }

    @Override
    public List<Client> findByLastname(String lastName) {
        return this.clientDao.findByLastNameContains(lastName);
    }
}
