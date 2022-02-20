package by.bsuir.dao.impl;

import by.bsuir.constant.ref.UserRoleRef;
import by.bsuir.constant.ref.UserStatusRef;
import by.bsuir.dao.RefDao;
import by.bsuir.entity.domain.UserRole;
import by.bsuir.entity.domain.UserStatus;
import by.bsuir.repo.UserRoleRepo;
import by.bsuir.repo.UserStatusRepo;
import org.springframework.stereotype.Component;

@Component
public class RefDaoImpl implements RefDao {

    private final UserStatusRepo userStatusRepo;
    private final UserRoleRepo userRoleRepo;

    public RefDaoImpl(UserStatusRepo userStatusRepo, UserRoleRepo userRoleRepo) {
        this.userStatusRepo = userStatusRepo;
        this.userRoleRepo = userRoleRepo;
    }

    @Override
    public UserStatus findNonActiveUserStatus() {
        return userStatusRepo.findByStatusName(UserStatusRef.NON_ACTIVE.getName());
    }

    @Override
    public UserStatus findActiveUserStatus() {
        return userStatusRepo.findByStatusName(UserStatusRef.ACTIVE.getName());
    }

    @Override
    public UserStatus findBannedUserStatus() {
        return userStatusRepo.findByStatusName(UserStatusRef.BANNED.getName());
    }

    @Override
    public UserStatus findGoogleActiveStatus() {
        return userStatusRepo.findByStatusName(UserStatusRef.GOOGLE_ACTIVE.getName());
    }

    @Override
    public UserRole findUserRole() {
        return userRoleRepo.findByRoleName(UserRoleRef.USER.getName());
    }

    @Override
    public UserRole findAdminUserRole() {
        return userRoleRepo.findByRoleName(UserRoleRef.ADMIN.getName());
    }

}
