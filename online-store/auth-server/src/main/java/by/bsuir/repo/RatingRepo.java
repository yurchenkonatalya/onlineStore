package by.bsuir.repo;

import by.bsuir.entity.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating, Integer> {
}
