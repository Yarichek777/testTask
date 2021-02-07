package org.yarik.testTask.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    @ElementCollection(
            targetClass = Role.class,
            fetch = FetchType.EAGER
    )
    @CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"))
    private Set<Role> roles;
    private boolean isActive;
}
