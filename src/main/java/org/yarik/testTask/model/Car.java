package org.yarik.testTask.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private CarBrand carBrand;
    @ManyToOne
    @JoinColumn(nullable = false)
    private CarModel carModel;
    @ManyToOne
    @JoinColumn(nullable = false)
    private TypeAuto typeAuto;
    private int year;
    private double volumeOfEngine;
    private int mileage;
    private int price;
    private String location;
    private boolean active;
    protected Car(){}
}
