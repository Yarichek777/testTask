package org.yarik.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> getAll();
    Optional<User> findByLoginAndPassword(String login, String password);
    User save(User user);
    boolean existsByLogin(String login);
    boolean existsByPassword(String password);
    Optional<User> findByLogin(String login);
}
