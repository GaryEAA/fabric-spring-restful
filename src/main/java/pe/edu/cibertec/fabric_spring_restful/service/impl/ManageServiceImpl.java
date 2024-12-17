package pe.edu.cibertec.fabric_spring_restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.fabric_spring_restful.dto.CarCreateDto;
import pe.edu.cibertec.fabric_spring_restful.dto.CarDetailDto;
import pe.edu.cibertec.fabric_spring_restful.dto.CarDto;
import pe.edu.cibertec.fabric_spring_restful.dto.CarUpdateDto;
import pe.edu.cibertec.fabric_spring_restful.entity.Car;
import pe.edu.cibertec.fabric_spring_restful.repository.CarRepository;
import pe.edu.cibertec.fabric_spring_restful.service.ManageService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getLicensePlate(),
                    car.getOwnerName(),
                    car.getMileage(),
                    car.getColor(),
                    car.getServiceDueDate()));
        });
        return cars;
    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDto(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()));

    }

    @Override
    public boolean updateCar(CarUpdateDto carUpdateDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carUpdateDto.carId());
        return optional.map(car -> {
            car.setMake(carUpdateDto.make());
            car.setModel(carUpdateDto.model());
            car.setYear(carUpdateDto.year());

            car.setLicensePlate(carUpdateDto.licensePlate());
            car.setOwnerContact(carUpdateDto.ownerName());

            car.setMileage(carUpdateDto.mileage());
            car.setEngineType(carUpdateDto.engineType());
            car.setColor(carUpdateDto.color());
            car.setInsuranceCompany(carUpdateDto.insuranceCompany());
            car.setInsurancePolicyNumber(carUpdateDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carUpdateDto.registrationExpirationDate());
            car.setServiceDueDate(carUpdateDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addCar(CarCreateDto carCreateDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carCreateDto.carId());
        if (optional.isPresent())
            return false;
        else {
            Car car = new Car();
            car.setMake(carCreateDto.make());
            car.setModel(carCreateDto.model());
            car.setYear(carCreateDto.year());
            car.setLicensePlate(carCreateDto.licensePlate());
            car.setOwnerName(carCreateDto.ownerName());
            car.setOwnerContact(carCreateDto.ownerContact());
            car.setPurchaseDate(carCreateDto.purchaseDate());
            car.setMileage(carCreateDto.mileage());
            car.setEngineType(carCreateDto.engineType());
            car.setColor(carCreateDto.color());
            car.setInsuranceCompany(carCreateDto.insuranceCompany());
            car.setInsurancePolicyNumber(carCreateDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carCreateDto.registrationExpirationDate());
            car.setServiceDueDate(carCreateDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }

    }

}
