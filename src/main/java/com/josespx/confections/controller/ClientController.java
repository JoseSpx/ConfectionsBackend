package com.josespx.confections.controller;

import com.josespx.confections.model.Client;
import com.josespx.confections.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController( ClientService clientService ) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Client> saveClient(@RequestBody Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.clientService.save(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }




}
