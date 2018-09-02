package com.josespx.confections.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.josespx.confections.model.Clothes;
import com.josespx.confections.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ClothesController {

    private ClothesService clothesService;

    @Autowired
    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @RequestMapping(value = "/clothes", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Clothes> saveClothes(@RequestBody Clothes clothes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.clothesService.save(clothes);
        return new ResponseEntity<>(clothes, HttpStatus.OK);
    }

    @JsonView(Clothes.Basic.class)
    @RequestMapping(value = "/clothes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Clothes> findById(@PathVariable("id") Long id) {
        Clothes clothes = this.clothesService.findById(id);
        if (clothes == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(clothes, HttpStatus.OK);
    }

    @JsonView(Clothes.Basic.class)
    @RequestMapping(value = "/clothes", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Clothes>> findAll() {
        List<Clothes> clothesList = this.clothesService.findAll();
        if (clothesList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(clothesList, HttpStatus.OK);
    }

    @JsonView(Clothes.Basic.class)
    @RequestMapping(value = "/clothes/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity<Clothes> updateClient(@PathVariable("id") Long id, @RequestBody Clothes clothes) {
        Clothes clothesToUpdate = this.clothesService.findById(id);
        if (clothesToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        clothesToUpdate.setName(clothes.getName());
        this.clothesService.save(clothesToUpdate);
        return new ResponseEntity<>(clothesToUpdate, HttpStatus.OK);
    }

    @RequestMapping(value = "/clothes/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Clothes> deleteById(@PathVariable("id") Long id) {
        Clothes clothes = this.clothesService.findById(id);
        if (clothes == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        clothes.setEliminated("1");
        this.clothesService.save(clothes);
        // this.clothesService.deleteById(id);
        return new ResponseEntity<>(clothes, HttpStatus.OK);
    }

}
