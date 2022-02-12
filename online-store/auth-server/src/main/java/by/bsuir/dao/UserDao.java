package by.bsuir.dao;

import by.bsuir.entity.domain.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Integer id);
    Optional<User> save(User user);
}
