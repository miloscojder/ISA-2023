package com.example.ISAproject.controllers;

import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    //Prikaz opreme
    @RequestMapping(value="api/equipments",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Equipment>> findAll()
    {
        List<Equipment> equipmentList= this.equipmentService.findAll();
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }


    //Pretraga opreme
    @RequestMapping(value="api/equipmentName/{name}", method = RequestMethod.GET,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Equipment>> findByName(@PathVariable String name){
        List<Equipment> equipmentList=this.equipmentService.findByEquipmentName(name);
        return new ResponseEntity<>(equipmentList,HttpStatus.OK);
    }



}
