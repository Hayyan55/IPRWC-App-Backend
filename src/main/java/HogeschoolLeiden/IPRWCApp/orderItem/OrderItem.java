package HogeschoolLeiden.IPRWCApp.orderItem;

import HogeschoolLeiden.IPRWCApp.product.Product;
import HogeschoolLeiden.IPRWCApp.user.AppUser;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_item")
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

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;
}