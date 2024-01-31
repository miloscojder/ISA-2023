package com.example.ISAproject.repository;

import com.example.ISAproject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByIsFree(boolean isFree);

    List<Appointment> findByIsFreeAndCompanyId(boolean isFree, Long id);

}
