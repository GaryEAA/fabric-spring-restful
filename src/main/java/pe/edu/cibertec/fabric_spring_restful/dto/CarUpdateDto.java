package pe.edu.cibertec.fabric_spring_restful.dto;

import java.util.Date;

public record CarUpdateDto(
        Integer carId,
        String make,
        String model,
        Integer year,

        String licensePlate,
        String ownerName,
        String ownerContact,

        Integer mileage,
        String engineType,
        String color,
        String insuranceCompany,
        String insurancePolicyNumber,
        Date registrationExpirationDate,
        Date serviceDueDate) {
}
