package pe.edu.cibertec.fabric_spring_restful.response;

import pe.edu.cibertec.fabric_spring_restful.dto.CarDto;

import java.util.List;

public record FindCarsResponse(
        String code,
        String error,
        List<CarDto> cars) {
}
