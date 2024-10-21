package com.example.vehiclemanagement.Entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {

    @NotBlank(message = "Vehicle name must not be empty")
    private String vehicleName;

    @NotBlank(message = "Vehicle type must not be empty")
    private String vehicleType;

    @Id
    private String registrationNumber;


     @Positive
    private double price;

     @Min(value = 1886, message = "Year must be at least till 1886") @Max(value = 2024, message = "Year can't surpass current date")
    private int yearManufacture;

     @Positive(message = "Value must be positve")
    private int mileage;
}
