package com.example.ISAproject.dto;

import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.Equipment;

import java.util.List;

public class ScheduleTermDTO {
    private Long appointmentId;
    private Long companyId;
    private Long registeredUserId;
    private List<Equipment> equipments;

    public ScheduleTermDTO() {
    }

    public ScheduleTermDTO(Long appointmentId, Long companyId, Long registeredUserId, List<Equipment> equipments) {
        this.appointmentId = appointmentId;
        this.companyId = companyId;
        this.registeredUserId = registeredUserId;
        this.equipments = equipments;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Long registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

}
