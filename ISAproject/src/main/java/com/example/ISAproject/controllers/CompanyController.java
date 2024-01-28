package com.example.ISAproject.controllers;

import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.service.CompanyService;
import com.example.ISAproject.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private EquipmentService equipmentService;

    //Prikaz svih kompanija
    @RequestMapping(value="api/companies",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Company>> findAll()
    {
        List<Company> companies= this.companyService.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    //Pretraga kompanija
    @RequestMapping(value="api/companyName/{name}", method = RequestMethod.GET,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Company>> findByName(@PathVariable String name){
        List<Company> companies=this.companyService.findByCompanyName(name);
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }
    @RequestMapping(value="api/companyId/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Company> getById(@PathVariable Long id)
    {

        Company company =this.companyService.findById(id);

        return new ResponseEntity<>(company,HttpStatus.OK);
    }

    @RequestMapping(value="api/company/equipment/{id}",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Equipment>> findAllEquipmentByCompany(@PathVariable Long id)
    {
        List<Equipment> equipments=this.equipmentService.findAllEquipmentByCompany(id);
        return new ResponseEntity<>(equipments,HttpStatus.OK);
    }

}
