package HogeschoolLeiden.IPRWCApp.orderItem;

import HogeschoolLeiden.IPRWCApp.order.Order;
import HogeschoolLeiden.IPRWCApp.product.Product;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDER_ITEM")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product", referencedColumnName = "id", updatable = false, nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order orderCart;
}