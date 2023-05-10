package com.tobi.rentalmanagementsystem.Repository;

import com.tobi.rentalmanagementsystem.Entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<PropertyEntity, Long> {
    PropertyEntity findByLocation(String location);
    Boolean isExistsByName(String nameOfObject);
    PropertyEntity findByPropertyType(String propertyType);

    PropertyEntity findByOccupiedStatus(String occupiedStatus);



}
