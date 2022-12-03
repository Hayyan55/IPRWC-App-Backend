package HogeschoolLeiden.IPRWCApp.orderItem;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto toDTO(OrderItem orderItem);

    List<OrderItemDto> toDTOs(List<OrderItem> orderItem);
}