package com.example.ISAproject.service;

import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.repository.CompanyRepository;
import com.example.ISAproject.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> findAll(){return this.equipmentRepository.findAll();}

    public List<Equipment> findByEquipmentNameContaining(String name){
        return this.equipmentRepository.findByNameContaining(name);


    /*    List<Equipment> allEquipments = this.equipmentRepository.findAll();
        List<Equipment> equipments = new ArrayList<>();

        for(Equipment e : allEquipments){
            if(e.getName().toLowerCase().contains(name.toLowerCase())){
                equipments.add(e);
            }
        }
        return equipments;
    //    return this.equipmentRepository.findByName(name);
        */
    }

}
