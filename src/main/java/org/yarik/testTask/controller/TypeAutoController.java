package org.yarik.testTask.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yarik.testTask.model.TypeAuto;
import org.yarik.testTask.service.TypeAutoService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/typeAuto")
@Tag(name = "typeAuto", description = "methods for typeAuto")
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

    @PostMapping("add")
    public TypeAuto addTypeAuto(@Valid @RequestBody TypeAuto typeAuto) {
        return typeAutoService.save(typeAuto);
    }

    @DeleteMapping("delete/{name}")
    public void deleteTypeAuto(@PathVariable String name) {
        typeAutoService.deleteByType(name);
    }
}
