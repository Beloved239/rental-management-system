package com.tobi.rentalmanagementsystem.Services;

import com.tobi.rentalmanagementsystem.Entity.PropertyEntity;
import com.tobi.rentalmanagementsystem.Exception.ResourceNotFoundException;
import com.tobi.rentalmanagementsystem.PropertyLoad.PropertyRequest;
import com.tobi.rentalmanagementsystem.Repository.RentalRepository;
import com.tobi.rentalmanagementsystem.Util.PropertyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class Services {
    @Autowired
    private RentalRepository rentalRepository;

    public PropertyRequest addProperty(PropertyRequest propertyRequest){
        PropertyEntity newProperty = new PropertyEntity();

        newProperty.setPropertyType(propertyRequest.getPropertyType());
        newProperty.setLocation(propertyRequest.getLocation());
        newProperty.setRentPerMonth(propertyRequest.getRentPerMonth());
        newProperty.setNumberOfBedroom(propertyRequest.getNumberOfBedroom());
        newProperty.setNumberOfBathroom(propertyRequest.getNumberOfBathroom());
        newProperty.setPropertyCode(PropertyCode.generatePropertyCode(propertyRequest.getPropertyType()));
        newProperty.setPropertyCode(propertyRequest.getPropertyType());
        newProperty.setAmenities(propertyRequest.getAmenities());
        newProperty.setRentalIncome(propertyRequest.getRentPerMonth()* propertyRequest.getNumberOfBedroom());
        newProperty.setFloorNumber(propertyRequest.getFloorNumber());
        newProperty.setYardSize(propertyRequest.getYardSize());
        newProperty.setOccupiedStatus(propertyRequest.isOccupiedStatus());
        newProperty.setNumberOfFloors(propertyRequest.getNumberOfFloors());
//        newProperty.setId();
        PropertyEntity savedProperty = rentalRepository.save(newProperty);

        PropertyRequest response = new PropertyRequest();
        response.setPropertyType(savedProperty.getPropertyType());
        response.setLocation(savedProperty.getLocation());
        response.setNumberOfBedroom(savedProperty.getNumberOfBedroom());
        response.setNumberOfBathroom(savedProperty.getNumberOfBathroom());
        response.setRentPerMonth(savedProperty.getRentPerMonth());
        response.setOccupiedStatus(savedProperty.isOccupiedStatus());
        response.setFloorNumber(savedProperty.getFloorNumber());
        response.setNumberOfFloors(savedProperty.getNumberOfFloors());
        response.setAmenities(savedProperty.getAmenities());
        response.setYardSize(savedProperty.getYardSize());

        return response;
    }

    public List<PropertyEntity> getAllRegisteredProperties(){
        return rentalRepository.findAll();
    }


    public ResponseEntity<PropertyEntity> getPropertyById(@PathVariable Long id) {
        PropertyEntity propertyEntity = rentalRepository.findById(id)
                .orElseThrow();
        return ResponseEntity.ok(propertyEntity);
    }

    //get property by Apartment, Location

    public String deleteProperty(@PathVariable Long Id){
        PropertyEntity propertyEntity = rentalRepository.findById(Id).orElseThrow();
        rentalRepository.deleteById(Id);
        return Id +" Deleted Successfully";
    }

    public ResponseEntity<PropertyEntity> updateProperties(@PathVariable Long id, @RequestBody PropertyRequest propertyRequest){
        PropertyEntity propertyEntity = rentalRepository.findById(id).orElseThrow();

        propertyEntity.setPropertyCode(PropertyCode.generatePropertyCode(propertyRequest.getPropertyType()));
        propertyEntity.setRentalIncome(propertyRequest.getRentPerMonth()* propertyRequest.getNumberOfBedroom());
        propertyEntity.setPropertyType(propertyRequest.getPropertyType());
        propertyEntity.setYardSize(propertyRequest.getYardSize());
        propertyEntity.setAmenities(propertyRequest.getAmenities());
        propertyEntity.setOccupiedStatus(propertyRequest.isOccupiedStatus());
        propertyEntity.setLocation(propertyRequest.getLocation());
        propertyEntity.setFloorNumber(propertyRequest.getFloorNumber());
        propertyEntity.setRentPerMonth(propertyRequest.getRentPerMonth());
        propertyEntity.setNumberOfFloors(propertyRequest.getNumberOfFloors());
        propertyEntity.setNumberOfBathroom(propertyRequest.getNumberOfBathroom());
        propertyEntity.setNumberOfBedroom(propertyRequest.getNumberOfBedroom());

        PropertyEntity updatedProperty = rentalRepository.save(propertyEntity);

        return ResponseEntity.ok(updatedProperty);
    }


    public PropertyEntity fetchPropertyByLocation(String location){
        Boolean isPropertyExist = rentalRepository.isExistsByName(location);
        if (isPropertyExist){
            return rentalRepository.findByLocation(location);
        }else {
            return null;
        }
    }


    public PropertyEntity fetchPropertyByPropertyType(String propertyType){
        Boolean isPropertyExist = rentalRepository.isExistsByName(propertyType);

        if (isPropertyExist){
            return rentalRepository.findByPropertyType(propertyType);
        }else {
            return null;
        }
    }



    public PropertyEntity fetchPropertyByOccupiedStatus(String occupiedStatus){
        Boolean isPropertyExist = rentalRepository.isExistsByName(occupiedStatus);
        if (isPropertyExist){
            return rentalRepository.findByOccupiedStatus(occupiedStatus);
        }else {
            return null;
        }
    }
}

