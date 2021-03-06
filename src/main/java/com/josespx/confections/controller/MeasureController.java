package com.josespx.confections.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.josespx.confections.model.Client;
import com.josespx.confections.model.Clothes;
import com.josespx.confections.model.Measure;
import com.josespx.confections.model.TypeMeasure;
import com.josespx.confections.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class MeasureController {

    private MeasureService measureService;

    @Autowired
    public MeasureController(MeasureService measureService) {
        this.measureService = measureService;
    }

    @RequestMapping(value = "/measures", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Measure> saveMeasure(@RequestBody Measure measure) {
        this.measureService.save(measure);
        return new ResponseEntity<>(measure, HttpStatus.OK);
    }


    @JsonView(MeasureDetailFull.class)
    @RequestMapping(value = "/measures/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Measure> findById(@PathVariable("id") Long id) {
        Measure measure = this.measureService.findById(id);
        if (measure == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(measure, HttpStatus.OK);
    }

    @JsonView(Measure.Basic.class)
    @RequestMapping(value = "/measures", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Measure>> findAll() {
        List<Measure> measureList = this.measureService.findAll();
        return new ResponseEntity<>(measureList, HttpStatus.OK);
    }

    interface MeasureDetailFull extends Measure.Basic, Measure.Detail, Client.Basic {}

    @JsonView(MeasureDetailFull.class)
    @RequestMapping(value = "/measures/client/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Measure>> findAllByClientId(@PathVariable("id") Long id) {
        List<Measure> measureList = this.measureService.findAllByClientId(id);
        return new ResponseEntity<>(measureList, HttpStatus.OK);
    }

    interface MeasureWithTypeMasure extends Measure.Basic, Measure.Detail, TypeMeasure.Basic {}

    @JsonView(MeasureWithTypeMasure.class)
    @RequestMapping(value = "/measures/client/{idClient}/clothes/{idClothes}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Measure>> findAllByClientId(@PathVariable("idClient") Long idClient, @PathVariable("idClothes") Long idClothes) {
        List<Measure> measureList = this.measureService
                .findAllByClientIdAndTypeMeasureClothesId(idClient, idClothes, "0", "0");
        return new ResponseEntity<>(measureList, HttpStatus.OK);
    }

    @JsonView(Measure.Basic.class)
    @RequestMapping(value = "/measures/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity<Measure> updateMeasure(@PathVariable("id") Long id, @RequestBody Measure measure) {
        Measure measuretoUpdate = this.measureService.findById(id);
        if (measuretoUpdate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        measuretoUpdate.setModel(measure.getModel());
        this.measureService.save(measuretoUpdate);
        return new ResponseEntity<>(measuretoUpdate, HttpStatus.OK);
    }

    @JsonView(Measure.Basic.class)
    @RequestMapping(value = "/measures/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Measure> deleteById(@PathVariable("id") Long id) {
        Measure measure = this.measureService.findById(id);
        if (measure == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.measureService.deleteById(id);
        return new ResponseEntity<>(measure ,HttpStatus.OK);
    }


}
