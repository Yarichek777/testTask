package org.yarik.testTask.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yarik.testTask.model.Role;
import org.yarik.testTask.model.User;
import org.yarik.testTask.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    protected final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAll(){
        return userRepository.findAllByOrderByLogin();
    }
    public Optional<User> findByLoginAndPassword(String login, String password){
        return userRepository.findByLoginAndPassword(login, password);
    }
    public User save(User user){
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        return userRepository.save(user);
    }
    public boolean existsByLogin(String login){
        return userRepository.existsByLogin(login);
    }
    public boolean existsByPassword(String password){
        return userRepository.existsByPassword(password);
    }
    public Optional<User> findById(long id){ return  userRepository.findById(id);}
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       return userRepository.findByLogin(s);
    }
}
