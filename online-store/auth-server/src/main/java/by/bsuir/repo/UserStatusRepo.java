package by.bsuir.repo;

import by.bsuir.entity.domain.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepo extends JpaRepository<UserStatus, Integer> {
    UserStatus findByUserStatusName(String name);
}
