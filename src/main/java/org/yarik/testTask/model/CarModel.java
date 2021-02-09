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
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "field 'name' must not be empty!")
    @Size(min = 2, max = 20)
    private String name;
    @ManyToOne
    @JoinColumn(nullable = false)
    private CarBrand carBrand;
    @OneToMany(
            mappedBy = "carModel",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<Car> cars;

}
