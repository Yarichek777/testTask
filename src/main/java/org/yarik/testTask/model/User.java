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
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "field 'login' must not be empty!")
    @Size(min = 3, max = 20)
    private String login;
    @NotBlank(message = "field 'password' must not be empty!")
    @Size(min = 3, max = 20)
    private String password;
    @Enumerated(EnumType.STRING)
    @ElementCollection(
            targetClass = Role.class,
            fetch = FetchType.EAGER
    )
    @CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"))
    private Set<Role> roles;
    @NotBlank(message = "field 'isActive' must not be empty!")
    private boolean isActive;
}
