package HogeschoolLeiden.IPRWCApp.product;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    boolean existsById(@NotNull Long id);
    boolean existsByProductName(String productName);
    Product findByProductName(String productName);
}
