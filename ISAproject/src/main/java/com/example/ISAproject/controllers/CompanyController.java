package com.example.ISAproject.controllers;

import com.example.ISAproject.model.Company;
import com.example.ISAproject.service.CompanyService;
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


}
