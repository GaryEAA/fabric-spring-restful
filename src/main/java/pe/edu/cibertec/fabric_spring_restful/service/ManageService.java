package pe.edu.cibertec.fabric_spring_restful.service;

import pe.edu.cibertec.fabric_spring_restful.dto.CarCreateDto;
import pe.edu.cibertec.fabric_spring_restful.dto.CarDetailDto;
import pe.edu.cibertec.fabric_spring_restful.dto.CarDto;
import pe.edu.cibertec.fabric_spring_restful.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {
    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarUpdateDto carUpdateDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarCreateDto carCreateDto) throws Exception;

}
