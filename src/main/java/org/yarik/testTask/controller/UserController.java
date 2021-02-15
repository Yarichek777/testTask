package org.yarik.testTask.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yarik.testTask.model.User;
import org.yarik.testTask.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Tag(name = "user", description = "methods for user")
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("getAll")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("findById/{id}")
    public User findUserById(@PathVariable long id) {
        return userService.findById(id).get();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("deleteById/{id}")
    public void deleteUserById(@PathVariable long id) {
        Optional<User> user = userService.findById(id);
        user.get().setActive(false);
        userService.deleteById(id);
        userService.save(user.get());
    }


}