package by.bsuir.repo;

import by.bsuir.entity.domain.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStatusRepo extends JpaRepository<ProductStatus, Integer> {
}
