package com.example.vehiclemanagement;

import com.example.vehiclemanagement.Entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Connection  extends MongoRepository<Vehicle, String> {
}
