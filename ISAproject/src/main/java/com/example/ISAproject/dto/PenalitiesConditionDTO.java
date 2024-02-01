package com.example.ISAproject.dto;

public class PenalitiesConditionDTO {
    private  boolean banPenalities;

    public boolean isBanPenalities() {
        return banPenalities;
    }

    public void setBanPenalities(boolean banPenalities) {
        this.banPenalities = banPenalities;
    }

    public PenalitiesConditionDTO() {
    }

    public PenalitiesConditionDTO(boolean banPenalities) {
        this.banPenalities = banPenalities;
    }
}
