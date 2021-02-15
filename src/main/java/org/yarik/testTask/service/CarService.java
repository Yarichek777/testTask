package org.yarik.testTask.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.yarik.testTask.model.Car;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.model.CarModel;
import org.yarik.testTask.model.TypeAuto;
import org.yarik.testTask.repository.CarRepository;

import java.util.Optional;

@Service
public class CarService {

    protected final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Page<Car> findAllOrderByPrice(Pageable pageable) {
        return carRepository.findAllByOrderByPrice(pageable);
    }

    public Page<Car> findAllByCarBrand(Optional<CarBrand> carBrand, Pageable pageable) {
        return carRepository.findAllByCarBrand(carBrand, pageable);
    }

    public Page<Car> findAllByCarModel(Optional<CarModel> carModel, Pageable pageable) {
        return carRepository.findAllByCarModel(carModel, pageable);
    }

    public Page<Car> findAllByPriceBetween(int minPrice, int maxPrice, Pageable pageable) {
        return carRepository.findAllByPriceBetween(minPrice, maxPrice, pageable);
    }

    public Page<Car> findAllByYearBetween(int minYear, int maxYear, Pageable pageable) {
        return carRepository.findAllByYearBetween(minYear, maxYear, pageable);
    }

    public Page<Car> findAllByMileageBefore(int maxMileage, Pageable pageable) {
        return carRepository.findAllByMileageBefore(maxMileage, pageable);
    }

    public Page<Car> findAllByVolumeOfEngineBetween(double minValue, double maxValue, Pageable pageable) {
        return carRepository.findAllByVolumeOfEngineBetween(minValue, maxValue, pageable);
    }

    public Page<Car> findAllByActive(boolean active, Pageable pageable) {
        return carRepository.findAllByActive(active, pageable);
    }

    public Page<Car> findAllByTypeAuto(Optional<TypeAuto> typeAuto, Pageable pageable) {
        return carRepository.findAllByTypeAuto(typeAuto, pageable);
    }

    public Optional<Car> findById(long id) {
        return carRepository.findById(id);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void deleteById(long id) {
        carRepository.deleteById(id);
    }
}
