package com.example.ISAproject.repository;

import com.example.ISAproject.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByOrderByName();
    List<Company> findByName(String name);


}
