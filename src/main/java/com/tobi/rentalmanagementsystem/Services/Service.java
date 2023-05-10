package com.tobi.rentalmanagementsystem.Services;

import com.tobi.rentalmanagementsystem.Entity.PropertyEntity;
import com.tobi.rentalmanagementsystem.PropertyLoad.PropertyRequest;
import com.tobi.rentalmanagementsystem.Repository.RentalRepository;

import java.util.List;

public interface Service {
    PropertyRequest addNewProperty (PropertyRequest propertyRequest);

    List<PropertyEntity> getAllRegisteredProperties();
}
