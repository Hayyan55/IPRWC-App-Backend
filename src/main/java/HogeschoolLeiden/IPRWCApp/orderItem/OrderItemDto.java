package HogeschoolLeiden.IPRWCApp.orderItem;

import HogeschoolLeiden.IPRWCApp.order.Order;
import HogeschoolLeiden.IPRWCApp.product.ProductDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link OrderItem} entity
 */
@Getter
@Setter
public class OrderItemDto {
    private Long id;
    private ProductDto product;
    private int quantity;
    private Date createdAt;
    private Date updatedAt;
    private Order orderCart;
}