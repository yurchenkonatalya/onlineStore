package by.bsuir.repo;

import by.bsuir.entity.domain.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageStatusRepo extends JpaRepository<MessageStatus, Integer> {
}
