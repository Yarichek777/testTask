package org.yarik.testTask.service;

import org.springframework.stereotype.Service;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.model.CarModel;
import org.yarik.testTask.repository.CarModelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelService {

    protected final CarModelRepository carModelRepository;
    public CarModelService(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }

    public List<CarModel> findAllOrderByName(){
        return carModelRepository.findAllByOrderByName();
    }
    public Optional<CarModel> findById(long id){ return  carModelRepository.findById(id);}
    public Optional<CarModel> findByName(String name){
        return carModelRepository.findByName(name);
    }
    public CarModel save (CarModel carModel){
        return carModelRepository.save(carModel);
    }
    public void deleteByName(String name){
        carModelRepository.deleteByName(name);
    }

}
