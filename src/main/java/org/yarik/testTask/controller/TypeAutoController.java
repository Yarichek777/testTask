package org.yarik.testTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yarik.testTask.model.TypeAuto;
import org.yarik.testTask.service.TypeAutoService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/typeAuto")
@AllArgsConstructor
public class TypeAutoController {

    private final TypeAutoService typeAutoService;

    @GetMapping("getAll")
    public List<TypeAuto> getAllTypesAuto() {
        return typeAutoService.findAllOrderByType();
    }

    @GetMapping("findByName/{name}")
    public TypeAuto findTypeAutoByName(@PathVariable String name) {
        return typeAutoService.findByType(name).get();
    }

    @GetMapping("findById/{id}")
    public TypeAuto findTypeAutoById(@PathVariable long id) {
        return typeAutoService.findById(id).get();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add")
    public TypeAuto addTypeAuto(@Valid @RequestBody TypeAuto typeAuto) {
        return typeAutoService.save(typeAuto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{name}")
    public void deleteTypeAuto(@PathVariable String name) {
        typeAutoService.deleteByType(name);
    }
}
