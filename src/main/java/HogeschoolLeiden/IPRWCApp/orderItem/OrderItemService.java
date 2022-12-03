package HogeschoolLeiden.IPRWCApp.orderItem;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class OrderItemService {
    @Autowired
    private OrderItemRepo orderItemRepo;

    private OrderItemMapper orderItemMapper = new OrderItemMapperImpl();

    public OrderItemDto addOrderItemToCart(OrderItem orderItem) {
        log.info("Saving new Order-Item: {} to the database.", orderItem.getProduct().getProductName());
        if (orderItem.getProduct().getProductName() != null) {
            orderItemRepo.save(orderItem);
            return orderItemMapper.toDTO(orderItem);
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Order-Item with order-id: " + orderItem.getId() + " doesn't exist between products."
        );
    }

    public List<OrderItemDto> getAllOrderItemsDto() {
        List<OrderItem> orderItemList = orderItemRepo.findAll();
        log.info(orderItemList.toString());
        return orderItemMapper.toDTOs(orderItemList);
    }

    public OrderItemDto getOrderItemDto(Long id) {
        OrderItem orderItem = getOrderItem(id);
        return orderItemMapper.toDTO(orderItem);
    }

    private OrderItem getOrderItem(Long id) {
        return orderItemRepo.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public void deleteOrderItem(Long id){
        if (!orderItemRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No OrderItem found with id: " + id);
        }
        orderItemRepo.deleteById(id);
    }
}
