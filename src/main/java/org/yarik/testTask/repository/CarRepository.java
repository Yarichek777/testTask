package org.yarik.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.Car;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.model.CarModel;
import org.yarik.testTask.model.TypeAuto;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAll();
    List<Car> findAllByCarBrand(CarBrand carBrand);
    List<Car> findAllByCarBrandAndCarModel(CarBrand carBrand, CarModel carModel);
    List<Car> findAllByCarBrandOrderByPrice(CarBrand carBrand);
    List<Car> findAllByPriceBetween(int minPrice, int maxPrice);
    List<Car> findAllByYearBetween(int minYear, int maxYear);
    List<Car> findAllByMileageBefore(int maxMileage);
    List<Car> findAllByVolumeOfEngineBetween(double minValue, double maxValue);
    List<Car> findAllByActive(boolean active);
    List<Car> findAllByTypeAuto(TypeAuto typeAuto);
    Optional<Car> findById(long id);
    Car save(Car car);
    void deleteById(long id);
}
