package org.yarik.testTask.service;

import org.yarik.testTask.model.User;
import org.yarik.testTask.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    protected final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
    public Optional<User> findByLoginAndPassword(String login, String password){
        return userRepository.findByLoginAndPassword(login, password);
    }
    public User save(User user){
        return userRepository.save(user);
    }
    public boolean existsByLogin(String login){
        return userRepository.existsByLogin(login);
    }
    public boolean existsByPassword(String password){
        return userRepository.existsByPassword(password);
    }
    public Optional<User> findByLogin(String login){
        return userRepository.findByLogin(login);
    }
}
