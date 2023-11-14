package com.example.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ISAproject.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	List<Authority> findByName(String name);
}
