package HogeschoolLeiden.IPRWCApp.orderItem;

import HogeschoolLeiden.IPRWCApp.product.ProductDto;
import HogeschoolLeiden.IPRWCApp.user.AppUser;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * A DTO for the {@link OrderItem} entity
 */
@Getter
@Setter
public class OrderItemDto {
//    private Long id;
    private ProductDto product;
    private int quantity;
    private Date createdAt;
    private Date updatedAt;
    private AppUser appUser;
}