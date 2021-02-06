package org.yarik.testTask.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Locale;
import java.util.Set;

@Entity
@Data
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(nullable = false)
    private CarBrand carBrand;
    @OneToMany(
            mappedBy = "car",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<Car> cars;
    protected CarModel(){}

}
