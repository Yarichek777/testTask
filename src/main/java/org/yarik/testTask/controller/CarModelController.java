package org.yarik.testTask.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.model.CarModel;
import org.yarik.testTask.service.CarModelService;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("api/carModel")
@Tag(name = "carModel", description = "methods for carModel")
@AllArgsConstructor
public class CarModelController {

    private final CarModelService carModelService;

    @GetMapping("getAll")
    public List<CarModel> getAllCarModels() {
        return carModelService.findAllOrderByName();
    }

    @GetMapping("findByName/{name}")
    public CarModel findCarModelByName(@PathVariable String name) {
        return carModelService.findByName(name).get();
    }

    @GetMapping("findById/{id}")
    public CarModel findCarNameById(@PathVariable long id) {
        return carModelService.findById(id).get();
    }

    @PostMapping("add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public CarModel addCarModel(@Valid @RequestBody CarModel carModel) {
        return carModelService.save(carModel);
    }

    @DeleteMapping("delete/{name}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteCarBrand(@PathVariable String name) {
        carModelService.deleteByName(name);
    }
}
