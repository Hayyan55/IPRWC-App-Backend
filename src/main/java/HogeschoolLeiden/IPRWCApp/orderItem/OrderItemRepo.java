package HogeschoolLeiden.IPRWCApp.orderItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

    boolean existsById(Long id);

    @Query(
            value =
                    "SELECT   * "
                            + "FROM      order_item oi "
                            + "WHERE    oi.user_id = ?1 "
                            + "AND      oi.product = ?2 "
                            + "ORDER BY created_at DESC ",
            nativeQuery = true)
    List<OrderItem> findAllByAppUserAndProduct(Long userId, Long productId);

    @Query(
            value =
                    "SELECT   * "
                            + "FROM      order_item oi "
                            + "WHERE    oi.user_id = ?1 "
                            + "ORDER BY created_at DESC ",
            nativeQuery = true)
    List<OrderItem> findAllByAppUser(Long userId);
}