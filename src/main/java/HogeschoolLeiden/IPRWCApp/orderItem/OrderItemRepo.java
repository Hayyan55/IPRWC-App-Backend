package HogeschoolLeiden.IPRWCApp.orderItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

    boolean existsById(Long id);
    OrderItem findOrderItemById(Long id);
}