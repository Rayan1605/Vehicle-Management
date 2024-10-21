package com.example.vehiclemanagement.controller;

import com.example.vehiclemanagement.Entity.Vehicle;
import com.example.vehiclemanagement.Service.VehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicle")
public class controller {

    private VehicleService vehicleService;
    @GetMapping("/retrieve/{number}")
    public ResponseEntity<Optional<String>> RetrieveViaRegristration(@Valid  @PathVariable String number){
       return vehicleService.get(number);
    }

    @PostMapping("/add")
    public ResponseEntity<String> AddVehicle(@Valid  Vehicle vehicle){
        return vehicleService.add(vehicle);
    }
    @PutMapping("/update")
    public ResponseEntity<String> Update(@Valid  Vehicle vehicle){
        return vehicleService.update(vehicle);
    }
}
