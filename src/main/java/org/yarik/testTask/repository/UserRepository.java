package org.yarik.testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yarik.testTask.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByOrderByLogin();
    Optional<User> findByLoginAndPassword(String login, String password);
    Optional<User> findById(long id);
    User save(User user);
    boolean existsByLogin(String login);
    boolean existsByPassword(String password);
    User findByLogin(String login);
}
