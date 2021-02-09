package org.yarik.testTask.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "field 'name' must not be empty!")
    @Size(min = 1, max = 30)
    private String name;
    @OneToMany(
            mappedBy = "carBrand",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<CarModel> carModels;
    @OneToMany(
            mappedBy = "carBrand",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<Car> cars;
}
