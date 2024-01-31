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

    @Autowired
    private CompanyService companyService;

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

    //Pretraga opreme po centru
    public List<Equipment> findAllEquipmentByCompany(Long id)
    {
        List<Equipment> allEquipment = equipmentRepository.findAll();
        List<Equipment> findedEquipment = new ArrayList<>();
        System.out.println("Trazenje opreme po centru");
        for(Equipment dt: allEquipment)
        {
            if(dt.getCompany().getId() == id)
            {
                System.out.println("Prikupljamo opremu iz centraID: " + id + dt.getName());
                findedEquipment.add(dt);

            }
        }

        return findedEquipment;
    }
    public List<Equipment> findAllEquipmentByCompanyByEquipmentNameContaining(Long id, String name){
        List<Equipment> companyEquipments = this.findAllEquipmentByCompany(id);
        List<Equipment> equipments = new ArrayList<>();

        /*if(name.equals("")){
            return companyEquipments;
        }*/

        for(Equipment e : companyEquipments){
            if(e.getName().toLowerCase().contains(name.toLowerCase())){
                equipments.add(e);
            }
        }
        return equipments;
    }

    public List<Equipment> getEquipmentByIds(List<Long> equipmentIds){
        List<Equipment> allEquipments = this.findAll();
        List<Equipment> foundedEquipments = new ArrayList<>();

        for(Long equipmentId : equipmentIds){
            for(Equipment equipment : allEquipments){
                if(equipmentId.equals(equipment.getId())){
                    foundedEquipments.add(equipment);
                    break;
                }
            }
        }
        return foundedEquipments;
    }

}
