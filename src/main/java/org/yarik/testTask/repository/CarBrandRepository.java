package org.yarik.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.CarBrand;

import java.util.List;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
    List<CarBrand> getAll();
    List<CarBrand> findAllByName(String name);
    CarBrand save(CarBrand carBrand);
    void deleteByName(String name);
}
