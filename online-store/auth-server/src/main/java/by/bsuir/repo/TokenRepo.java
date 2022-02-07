package by.bsuir.repo;

import by.bsuir.entity.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, String> {
    Optional<Token> findByToken(String token);
    void deleteByEndDateBefore(Date date);
}
