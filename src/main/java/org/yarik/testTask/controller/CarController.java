package org.yarik.testTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yarik.testTask.model.Car;
import org.yarik.testTask.service.CarBrandService;
import org.yarik.testTask.service.CarModelService;
import org.yarik.testTask.service.CarService;
import org.yarik.testTask.service.TypeAutoService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/car")
@AllArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarBrandService carBrandService;
    private final CarModelService carModelService;
    private final TypeAutoService typeAutoService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("getAll")
    public Page<Car> getAllCars(@PageableDefault Pageable pageable) {
        return carService.findAllOrderByPrice(pageable);
    }

    @GetMapping("findByCarBrand/{name}, {page}")
    public Page<Car> findCarByCarBrand(@PathVariable String name, @PageableDefault Pageable pageable) {
        return carService.findAllByCarBrand(carBrandService.findByName(name), pageable);
    }

    @GetMapping("findByCarModel/{name}")
    public Page<Car> findCarByCarModel(@PathVariable String name, @PageableDefault Pageable pageable) {
        return carService.findAllByCarModel(carModelService.findByName(name), pageable);
    }

    @GetMapping("findByPriceBetween/{min},{max}")
    public Page<Car> findCarByPriceBetween(@PathVariable int min, @PathVariable int max, @PageableDefault Pageable pageable) {
        return carService.findAllByPriceBetween(min, max, pageable);
    }

    @GetMapping("findByYearBetween/{min},{max}")
    public Page<Car> findCarByYearBetween(@PathVariable int min, @PathVariable int max, @PageableDefault Pageable pageable) {
        return carService.findAllByYearBetween(min, max, pageable);
    }

    @GetMapping("findByMileageBefore/{mileage}")
    public Page<Car> findCarByMileageBefore(@PathVariable int mileage, @PageableDefault Pageable pageable) {
        return carService.findAllByMileageBefore(mileage, pageable);
    }

    @GetMapping("findByVolumeEngineBetween/{min},{max}")
    public Page<Car> findCarByVolumeEngineBetween(@PathVariable double min, @PathVariable double max, @PageableDefault Pageable pageable) {
        return carService.findAllByVolumeOfEngineBetween(min, max, pageable);
    }

    @GetMapping("findByActive/{active}")
    public Page<Car> findCarByActive(@PathVariable boolean active, @PageableDefault Pageable pageable) {
        return carService.findAllByActive(active, pageable);
    }

    @GetMapping("findByTypeAuto/{name}")
    public Page<Car> findCarByTypeAuto(@PathVariable String name, @PageableDefault Pageable pageable) {
        return carService.findAllByTypeAuto(typeAutoService.findByType(name), pageable);
    }

    @GetMapping("findById/{id}")
    public Car findCarById(@PathVariable long id) {
        return carService.findById(id).get();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("add")
    public Car addCar(@Valid @RequestBody Car car) {
        return carService.save(car);
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("delete/{id}")
    public void deleteCar(@PathVariable long id) {
        Optional<Car> car = carService.findById(id);
        car.get().setActive(false);
        carService.deleteById(id);
        carService.save(car.get());
    }

}
