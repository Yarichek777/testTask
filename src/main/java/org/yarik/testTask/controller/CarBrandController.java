package org.yarik.testTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yarik.testTask.model.CarBrand;
import org.yarik.testTask.service.CarBrandService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/carBrand")
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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add")
    public CarBrand addCarBrand(@Valid @RequestBody CarBrand carBrand) {
        return carBrandService.save(carBrand);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{name}")
    public void deleteCarBrand(@PathVariable String name) {
        carBrandService.deleteByName(name);
    }

}
