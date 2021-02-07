package org.yarik.testTask.service;

import org.springframework.stereotype.Service;
import org.yarik.testTask.model.Car;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.model.CarModel;
import org.yarik.testTask.model.TypeAuto;
import org.yarik.testTask.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    protected final CarRepository carRepository;
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
    public List<Car> findAllByCarBrand(CarBrand carBrand){
        return carRepository.findAllByCarBrand(carBrand);
    }
    public List<Car> findAllByCarBrandAndCarModel(CarBrand carBrand, CarModel carModel){
        return carRepository.findAllByCarBrandAndCarModel(carBrand, carModel);
    }
    public List<Car> findAllByCarBrandOrderByPrice(CarBrand carBrand){
        return carRepository.findAllByCarBrandOrderByPrice(carBrand);
    }
    public List<Car> findAllByPriceBetween(int minPrice, int maxPrice){
        return carRepository.findAllByPriceBetween(minPrice, maxPrice);
    }
    public List<Car> findAllByYearBetween(int minYear, int maxYear){
        return carRepository.findAllByYearBetween(minYear, maxYear);
    }
    public List<Car> findAllByMileageBefore(int maxMileage){
        return carRepository.findAllByMileageBefore(maxMileage);
    }
    public List<Car> findAllByVolumeOfEngineBetween(double minValue, double maxValue){
        return carRepository.findAllByVolumeOfEngineBetween(minValue, maxValue);
    }
    public List<Car> findAllByActive(boolean active){
        return carRepository.findAllByActive(active);
    }
    public List<Car> findAllByTypeAuto(TypeAuto typeAuto){
        return carRepository.findAllByTypeAuto(typeAuto);
    }
    public Optional<Car> findById(long id){
        return carRepository.findById(id);
    }
    public Car save(Car car){
        return carRepository.save(car);
    }
    public void deleteById(long id){
        carRepository.deleteById(id);
    }
}
