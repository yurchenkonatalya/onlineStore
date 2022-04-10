package by.bsuir.repo;

import by.bsuir.entity.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {
}
