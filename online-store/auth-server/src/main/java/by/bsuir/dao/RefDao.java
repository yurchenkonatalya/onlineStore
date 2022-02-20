package by.bsuir.dao;

import by.bsuir.entity.domain.UserRole;
import by.bsuir.entity.domain.UserStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface RefDao {
    UserStatus findNonActiveUserStatus();
    UserStatus findActiveUserStatus();
    UserStatus findBannedUserStatus();
    UserStatus findGoogleActiveStatus();
    UserRole findUserRole();
    UserRole findAdminUserRole();
}
