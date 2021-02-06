package org.yarik.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.CarModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    List<CarModel> getAll();
    Optional<CarModel> findByName(String name);
    CarModel save(CarModel carModel);
    void deleteByName(String name);

}
