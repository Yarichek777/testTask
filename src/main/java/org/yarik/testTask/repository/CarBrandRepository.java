package org.yarik.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.CarBrand;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
    List<CarBrand> findAll();
    Optional<CarBrand> findByName(String name);
    CarBrand save(CarBrand carBrand);
    void deleteByName(String name);
}
