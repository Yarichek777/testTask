package org.yarik.testTask.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yarik.testTask.jwt.JwtTokenProvider;
import org.yarik.testTask.model.LoginViewModel;
import org.yarik.testTask.model.Role;
import org.yarik.testTask.model.User;
import org.yarik.testTask.service.UserService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "registration", description = "methods for auth/registration")
public class RegistrationController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public RegistrationController(UserService userService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/registration")
    public void registration (@RequestBody @Valid User user){
        if(userService.existsByPassword(user.getPassword()) || userService.existsByLogin(user.getPassword()))
            throw new IllegalArgumentException();
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginViewModel loginViewModel){
        String username = loginViewModel.getUsername();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginViewModel.getPassword()));
        User user = userService.findByLogin(username);
        String token = jwtTokenProvider.createToken(username, user.getRoles());
        Map<Object, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("token", token);
        return ResponseEntity.ok(response);
    }


}
