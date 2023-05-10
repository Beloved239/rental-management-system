package com.tobi.rentalmanagementsystem.Entity;

import jakarta.persistence.*;
//import lombok.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "properties")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min=1, max = 1000)
    private String propertyCode;

    private String propertyType;

    private String location;

    private double numberOfBedroom;

    private double numberOfBathroom;

    private double rentPerMonth;

    private boolean occupiedStatus;

    private double rentalIncome;



    private double floorNumber;

    private double numberOfFloors;

    @Size(min = 3, max = 10000)
    private String amenities;


    private double yardSize;


}
