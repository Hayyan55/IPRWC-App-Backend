package HogeschoolLeiden.IPRWCApp.orderItem;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderItemMapper {
    abstract OrderItemDto toDTO(OrderItem orderItem);

    abstract List<OrderItemDto> toDTOs(List<OrderItem> orderItem);

    public OrderItem toOrderItem(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setQuantity( orderItemDto.getQuantity() );
        orderItem.setCreatedAt( orderItemDto.getCreatedAt() );

        return orderItem;
    }
}