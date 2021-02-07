package org.yarik.testTask.service;

import org.springframework.stereotype.Service;
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

    List<TypeAuto> getAllTypesAuto(){
        return typeAutoRepository.findAll();
    }
    Optional<TypeAuto> findByType(String type){
        return typeAutoRepository.findByType(type);
    }
    TypeAuto save(TypeAuto typeAuto){
        return typeAutoRepository.save(typeAuto);
    }
    void deleteByType(String type){
        typeAutoRepository.deleteByType(type);
    }
}
