package org.yarik.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.Car;
import org.yarik.testTask.model.CarModel;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    List<CarModel> getAll();
    List<CarModel> findAllByName(String name);
    CarModel save();
    void deleteByName(String name);

}
