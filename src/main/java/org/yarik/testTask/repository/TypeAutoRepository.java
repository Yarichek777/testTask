package org.yarik.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.TypeAuto;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeAutoRepository extends JpaRepository<TypeAuto, Long> {
    List<TypeAuto> getAll();
    Optional<TypeAuto> findByType(String type);
    TypeAuto save(TypeAuto typeAuto);
    void deleteByType(String type);
}
