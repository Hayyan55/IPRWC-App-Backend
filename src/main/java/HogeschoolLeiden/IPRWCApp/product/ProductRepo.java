package HogeschoolLeiden.IPRWCApp.product;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    boolean existsById(Long id);
    boolean existsByProductName(String productName);
    Product findProductByProductName(String productName);
    void deleteProductByIdAndProductName(Long productId, String productName);
}
