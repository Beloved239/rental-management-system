package com.tobi.rentalmanagementsystem.Entity;

import lombok.Data;

@Data
public abstract class Properties {
    private String propertyType;
    private String location;
    private double numberOfBedroom;
    private double numberOfBathroom;
    private double rentPerMonth;
    private boolean occupiedStatus;


    public abstract double rentalIncome();






}
