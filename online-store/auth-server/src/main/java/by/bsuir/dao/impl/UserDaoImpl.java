package by.bsuir.dao.impl;

import by.bsuir.dao.UserDao;
import by.bsuir.entity.domain.User;
import by.bsuir.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    private final UserRepo userRepo;

    @Autowired
    public UserDaoImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByUserEmail(email);
    }

    @Override
    public Optional<User> findById(Integer id) {
       return userRepo.findById(id);
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.of(userRepo.save(user));
    }
}
