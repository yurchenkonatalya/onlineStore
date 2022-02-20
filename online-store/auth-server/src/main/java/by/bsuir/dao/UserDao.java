package by.bsuir.dao;

import by.bsuir.entity.domain.User;
import by.bsuir.entity.domain.UserStatus;

import java.util.Optional;

public interface UserDao {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndStatus(String email, UserStatus userStatus);
    Optional<User> findById(Integer id);
    Optional<User> save(User user);
}
