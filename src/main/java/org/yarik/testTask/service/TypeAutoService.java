package org.yarik.testTask.service;

import org.springframework.stereotype.Service;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.model.TypeAuto;
import org.yarik.testTask.repository.TypeAutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TypeAutoService {

    protected final TypeAutoRepository typeAutoRepository;
    public TypeAutoService(TypeAutoRepository typeAutoRepository) {
        this.typeAutoRepository = typeAutoRepository;
    }
    public List<TypeAuto> findAllOrderByType(){
        return typeAutoRepository.findAllByOrderByType();
    }
    public Optional<TypeAuto> findById(long id){ return  typeAutoRepository.findById(id);}
    public Optional<TypeAuto> findByType(String type){
        return typeAutoRepository.findByType(type);
    }
    public TypeAuto save(TypeAuto typeAuto){
        return typeAutoRepository.save(typeAuto);
    }
    public void deleteByType(String type){
        typeAutoRepository.deleteByType(type);
    }
}
