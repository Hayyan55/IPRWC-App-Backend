package HogeschoolLeiden.IPRWCApp.order;

import HogeschoolLeiden.IPRWCApp.orderItem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    boolean existsById(Long id);
    Order findOrderById(Long id);
}
