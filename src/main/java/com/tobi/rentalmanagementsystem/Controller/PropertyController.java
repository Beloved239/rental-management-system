package com.tobi.rentalmanagementsystem.Controller;

import com.tobi.rentalmanagementsystem.Entity.PropertyEntity;
import com.tobi.rentalmanagementsystem.PropertyLoad.PropertyRequest;
import com.tobi.rentalmanagementsystem.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PropertyController {

    @Autowired
    Services service;


    @PostMapping
    public PropertyRequest createProperty(@RequestBody PropertyRequest propertyRequest){
        return service.addProperty(propertyRequest);
    }

    @GetMapping("/property/{id}")
    public ResponseEntity<PropertyEntity> getPropertyById(@PathVariable Long id) {
        return service.getPropertyById(id);
    }

    @GetMapping("/{id}")
    public String deleteProperty(@PathVariable Long id){
        return service.deleteProperty(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyEntity> updatePropertyById(@PathVariable Long id, @RequestBody PropertyRequest propertyRequest){
        return service.updateProperties(id, propertyRequest);
    }

    @GetMapping("/property")
    public List<PropertyEntity> fetchAllProperty(){
        return service.getAllRegisteredProperties();
    }

}
