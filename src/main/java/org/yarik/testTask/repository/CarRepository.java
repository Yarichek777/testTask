package org.yarik.testTask.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.Car;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.model.CarModel;
import org.yarik.testTask.model.TypeAuto;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Page<Car> findAllByOrderByPrice(Pageable pageable);
    Page<Car> findAllByCarBrand(Optional<CarBrand> carBrand, Pageable pageable);
    Page<Car> findAllByCarModel(Optional<CarModel> carModel, Pageable pageable);
    Page<Car> findAllByPriceBetween(int minPrice, int maxPrice, Pageable pageable);
    Page<Car> findAllByYearBetween(int minYear, int maxYear, Pageable pageable);
    Page<Car> findAllByMileageBefore(int maxMileage, Pageable pageable);
    Page<Car> findAllByVolumeOfEngineBetween(double minValue, double maxValue, Pageable pageable);
    Page<Car> findAllByActive(boolean active, Pageable pageable);
    Page<Car> findAllByTypeAuto(Optional<TypeAuto> typeAuto, Pageable pageable);
    Optional<Car> findById(long id);
    Car save(Car car);
    void deleteById(long id);
}
