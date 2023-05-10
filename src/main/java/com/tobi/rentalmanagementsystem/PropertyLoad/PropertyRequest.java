package com.tobi.rentalmanagementsystem.PropertyLoad;


import lombok.Data;


@Data
public class PropertyRequest {

    private String propertyType;
    private String location;
    private double numberOfBedroom;
    private double numberOfBathroom;
    private double rentPerMonth;
    private boolean occupiedStatus;
    private double floorNumber;
    private double numberOfFloors;
    private String amenities;
    private double yardSize;
}
