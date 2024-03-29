package com.example.ISAproject.service;

import com.example.ISAproject.model.Company;
import com.example.ISAproject.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll(){return this.companyRepository.findAll();}

    public Company findById(Long id)
    {
        Optional<Company> opt=this.companyRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return opt.get();
    }

    public List<Company> findByCompanyName(String name){
        List<Company> allCompanies = this.companyRepository.findAll();
        List<Company> companies = new ArrayList<>();

        for(Company c : allCompanies){
            if(c.getName().toLowerCase().contains(name.toLowerCase())){
                companies.add(c);
            }
        }
        return companies;
        //return this.companyRepository.findByName(name);

    }

}
