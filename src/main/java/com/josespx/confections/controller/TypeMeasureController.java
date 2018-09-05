package com.josespx.confections.controller;

import com.josespx.confections.model.TypeMeasure;
import com.josespx.confections.service.TypeMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;


@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class TypeMeasureController {

    private TypeMeasureService typeMeasureService;

    @Autowired
    public TypeMeasureController(TypeMeasureService typeMeasureService) {
        this.typeMeasureService = typeMeasureService;
    }

    @RequestMapping(value = "/typemeasures", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<TypeMeasure> saveTypeMeasure(@RequestBody TypeMeasure typeMeasure) {
        typeMeasure.setEliminated("0");
        this.typeMeasureService.save(typeMeasure);
        return new ResponseEntity<>(typeMeasure ,HttpStatus.OK);
    }

    @RequestMapping(value = "/typemeasures/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<TypeMeasure> findById(@PathVariable("id") Long id) {
        TypeMeasure typeMeasure = this.typeMeasureService.findById(id);
        if (typeMeasure == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeMeasure, HttpStatus.OK);
    }


    @RequestMapping(value = "/typemeasures/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity<TypeMeasure> update(@PathVariable("id") Long id , @RequestBody TypeMeasure typeMeasure) {
        TypeMeasure typeMeasureToUpdate = this.typeMeasureService.findById(id);
        if (typeMeasureToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        typeMeasureToUpdate.setName(typeMeasure.getName());
        typeMeasureToUpdate.setEliminated("0");
        this.typeMeasureService.save(typeMeasureToUpdate);
        return new ResponseEntity<>(typeMeasureToUpdate, HttpStatus.OK);
    }

    @RequestMapping(value = "/typemeasures/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<TypeMeasure> delete(@PathVariable("id") Long id) {
        TypeMeasure typeMeasure = this.typeMeasureService.findById(id);
        if (typeMeasure == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        this.typeMeasureService.deleteById(id);
        return new ResponseEntity<>(typeMeasure, HttpStatus.OK);
    }



}
