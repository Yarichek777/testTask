package org.yarik.testTask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "field 'login' must not be empty!")
    @Size(min = 3, max = 20)
    private String login;
    @NotBlank(message = "field 'password' must not be empty!")
    @Size(min = 3)
    @Column(length = 1024)
    private String password;
    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @JsonIgnore
    private Set<Car> cars;
    @Enumerated(EnumType.STRING)
    @ElementCollection(
            targetClass = Role.class,
            fetch = FetchType.EAGER
    )
    @CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"))
    private Set<Role> roles;
    @NotBlank(message = "field 'isActive' must not be empty!")
    private boolean isActive;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return login;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return isActive;
    }

}
