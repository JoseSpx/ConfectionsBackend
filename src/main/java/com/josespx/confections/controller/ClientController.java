package com.josespx.confections.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.josespx.confections.model.Client;
import com.josespx.confections.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController( ClientService clientService ) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Client> saveClient(@RequestBody Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.clientService.save(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Client> deleteClientById(@PathVariable Long id) {
        Client client = this.clientService.findById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        client.setEliminated("1");
        this.clientService.save(client);
        // this.clientService.deleteById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Client clientSearched = this.clientService.findById(id);
        if (clientSearched == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        clientSearched.setId(client.getId());
        clientSearched.setName(client.getName());
        clientSearched.setLastName(client.getLastName());
        clientSearched.setAddress(client.getAddress());
        clientSearched.setDni(client.getDni());
        clientSearched.setPhone1(client.getPhone1());
        clientSearched.setPhone2(client.getPhone2());

        this.clientService.save(clientSearched);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @JsonView(Client.Basic.class)
    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Client> findClientById(@PathVariable("id") Long id){
        Client client = this.clientService.findById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @JsonView(Client.Basic.class)
    @RequestMapping(value = "/clients", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Client>> findAllClients(@RequestParam(value = "dni", required = false) String dni,
                                                       @RequestParam(value = "lastname", required = false) String lastname){

        if (dni != null && !dni.equals("")) {
            List<Client> listClients = this.clientService.findByDni(dni);
            if (listClients.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(listClients, HttpStatus.OK);
        }
        else if (lastname != null && !lastname.equals("")) {
            List<Client> listClients = this.clientService.findByLastname(lastname);
            if (listClients.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(listClients, HttpStatus.OK);
        }
        else {
            List<Client> listClients = this.clientService.findAll();
            if (listClients.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(listClients, HttpStatus.OK);
        }
    }



}
