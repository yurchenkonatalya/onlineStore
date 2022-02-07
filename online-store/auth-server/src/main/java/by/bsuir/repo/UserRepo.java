package by.bsuir.repo;

import by.bsuir.entity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserEmail(String email);
}
