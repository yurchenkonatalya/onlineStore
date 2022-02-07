package by.bsuir.repo;

import by.bsuir.entity.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {
    UserRole findByRoleName(String name);
}
