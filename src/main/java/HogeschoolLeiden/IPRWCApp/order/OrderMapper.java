package HogeschoolLeiden.IPRWCApp.order;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDTO(Order order);

    List<OrderDto> toDTOs(List<Order> order);
}
