package org.yarik.testTask.service;

import org.springframework.stereotype.Service;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.repository.CarBrandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarBrandService {

    protected final CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }
    public List<CarBrand> findAllOrderByName(){
        return carBrandRepository.findAllByOrderByName();
    }
    public Optional<CarBrand> findById(long id){ return  carBrandRepository.findById(id);}
    public Optional<CarBrand> findByName(String name){
        return carBrandRepository.findByName(name);
    }
    public CarBrand save(CarBrand carBrand){
        return carBrandRepository.save(carBrand);
    }
    public void deleteByName(String name){
        carBrandRepository.deleteByName(name);
    }
}
