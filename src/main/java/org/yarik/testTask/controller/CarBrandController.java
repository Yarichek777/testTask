package org.yarik.testTask.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.service.CarBrandService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/carBrand")
@Tag(name = "carBrand", description = "methods for carBrand")
@AllArgsConstructor
public class CarBrandController {

    private final CarBrandService carBrandService;

    @GetMapping("getAll")
    public List<CarBrand> getAllCarBrands() {
        return carBrandService.findAllOrderByName();
    }

    @GetMapping("findByName/{name}")
    public CarBrand findCarBrandByName(@PathVariable String name) {
        return carBrandService.findByName(name).get();
    }

    @GetMapping("findById/{id}")
    public CarBrand findCarBrandById(@PathVariable long id) {
        return carBrandService.findById(id).get();
    }

    @PostMapping("add")
    public CarBrand addCarBrand(@Valid @RequestBody CarBrand carBrand) {
        return carBrandService.save(carBrand);
    }

    @DeleteMapping("delete/{name}")
    public void deleteCarBrand(@PathVariable String name) {
        carBrandService.deleteByName(name);
    }

}
