package az.edu.ada.wm2.lab4.repository;

import az.edu.ada.wm2.lab4.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(UUID id);
    List<Product> findAll();
    void deleteById(UUID id);
    boolean existsById(UUID id);
}
