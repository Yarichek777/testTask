package org.yarik.testTask.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(
            mappedBy = "carModel",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<CarModel> carModels;
    @OneToMany(
            mappedBy = "car",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<Car> cars;
    protected CarBrand(){}
}
