package org.yarik.testTask.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    @NotBlank(message = "field 'carBrand' must not be empty!")
    private CarBrand carBrand;
    @ManyToOne
    @JoinColumn(nullable = false)
    @NotBlank(message = "field 'carModel' must not be empty!")
    private CarModel carModel;
    @ManyToOne
    @JoinColumn(nullable = false)
    @NotBlank(message = "field 'user' must not be empty!")
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    @NotBlank(message = "field 'typeAuto' must not be empty!")
    private TypeAuto typeAuto;
    @NotBlank(message = "field 'year' must not be empty!")
    @Size(min = 1900, max = 2021)
    private int year;
    @NotBlank(message = "field 'volumeEngine' must not be empty!")
    @Size(min = 0, max = 100)
    private double volumeOfEngine;
    @NotBlank(message = "field 'mileage' must not be empty!")
    @Size(min = 0)
    private int mileage;
    @NotBlank(message = "field 'price' must not be empty!")
    @Size(min = 0)
    private int price;
    @NotBlank(message = "field 'location' must not be empty!")
    @Size(min = 2, max = 30)
    private String location;
    @Size(min = 0, max = 2048)
    private String description;
    @Size(min = 2, max = 200)
    private String photoPath;
    @NotBlank(message = "field 'active' must not be empty!")
    private boolean active;
}
