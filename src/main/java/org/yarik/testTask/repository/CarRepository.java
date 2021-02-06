package org.yarik.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.Car;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.model.CarModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> getAll();
    List<Car> findAllByCarBrand(CarBrand carBrand);
    List<Car> findAllByCarBrandAndCarModel(CarBrand carBrand, CarModel carModel);
    Optional<Car> findById(long id);
    Car save(Car car);
}
