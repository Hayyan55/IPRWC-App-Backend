package HogeschoolLeiden.IPRWCApp.order;

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
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    private OrderMapper orderMapper;

    public Order addOrder(String orderProducts) {
        return null;
    }

    public List<OrderDto> getAllOrdersDto() {
        List<Order> orderList = orderRepo.findAll();
        log.info(orderList.toString());
        return orderMapper.toDTOs(orderList);
    }

    public OrderDto getOrderDto(Long id) {
        Order order = getOrder(id);
        return orderMapper.toDTO(order);
    }

    public Order getOrder(Long id) {
        return orderRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteOrder(Long id) {
        if (!orderRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No order found with id: " + id);
        }
        orderRepo.deleteById(id);
    }
}
