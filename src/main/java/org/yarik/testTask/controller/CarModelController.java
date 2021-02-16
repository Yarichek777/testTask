package org.yarik.testTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yarik.testTask.model.CarModel;
import org.yarik.testTask.service.CarModelService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/carModel")
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
    public CarModel addCarModel(@Valid @RequestBody CarModel carModel) {
        return carModelService.save(carModel);
    }

    @DeleteMapping("delete/{name}")
    public void deleteCarBrand(@PathVariable String name) {
        carModelService.deleteByName(name);
    }
}
