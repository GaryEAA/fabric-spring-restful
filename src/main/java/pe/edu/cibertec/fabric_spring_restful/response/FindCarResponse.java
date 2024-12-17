package pe.edu.cibertec.fabric_spring_restful.response;

import pe.edu.cibertec.fabric_spring_restful.dto.CarDetailDto;

public record FindCarResponse(
        String code,
        String error,
        CarDetailDto carDetailDto) {
}
