package pe.edu.cibertec.fabric_spring_restful.dto;

import java.util.Date;

public record CarDto(
        Integer carId,
        String make,
        String model,
        Integer year,
        String licensePlate,
        String ownerName,
        Integer mileage,
        String color,
        Date serviceDueDate) {
}
