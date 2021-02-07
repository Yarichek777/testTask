package org.yarik.testTask.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class TypeAuto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    @OneToMany(
            mappedBy = "typeAuto",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<Car> cars;
    protected TypeAuto(){}

}
