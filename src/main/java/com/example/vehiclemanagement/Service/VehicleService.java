package com.example.vehiclemanagement.Service;

import com.example.vehiclemanagement.Connection;
import com.example.vehiclemanagement.Entity.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleService {

    private Connection connection;
    public ResponseEntity<String> add(Vehicle vehicle){
        connection.save(vehicle);
        return ResponseEntity.ok("Added vehicle successfully ");
    }
    public ResponseEntity<String> update(Vehicle vehicle){
       connection.save(vehicle);
       return ResponseEntity.ok("Updated vehicle successfully ");
    }

    public ResponseEntity<Optional<String>> get(String number){
        Optional<Vehicle> vehicle = connection.findById(number);

        if (vehicle.isEmpty()){
            return ResponseEntity.of(Optional.of(Optional.of("404 error, ID is not found")));
        }

        return ResponseEntity.ok(Optional.of(vehicle.toString()));
    }
}
