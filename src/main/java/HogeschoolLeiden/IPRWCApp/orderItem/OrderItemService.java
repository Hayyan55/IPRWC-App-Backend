package HogeschoolLeiden.IPRWCApp.orderItem;

import HogeschoolLeiden.IPRWCApp.product.Product;
import HogeschoolLeiden.IPRWCApp.product.ProductRepo;
import HogeschoolLeiden.IPRWCApp.user.AppUser;
import HogeschoolLeiden.IPRWCApp.user.UserRepo;
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
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private OrderItemMapper orderItemMapper;

    public OrderItemDto addProductToCart(OrderItemDto orderItemDto) {
        OrderItem orderItem = orderItemMapper.toOrderItem(orderItemDto);
        Product product = productRepo.findProductById(orderItemDto.getProduct().getProductId());
        AppUser appUser = userRepo.findByUsername(orderItemDto.getAppUser().getUsername());
        if (product != null && appUser != null) {
            orderItem.setProduct(product);
            orderItem.setAppUser(appUser);
        }
        log.info("Saving new Order-Item: {} to the database.", orderItem.getProduct().getId());
        if (orderItem.getProduct().getId() != null) {
            if (!orderItemRepo.findAllByAppUserAndProduct(orderItem.getAppUser().getId(), orderItem.getProduct().getId()).isEmpty()) {
                this.incrementExistingItemQuantity(orderItem);
            } else {
                orderItemRepo.save(orderItem);
            }
            return orderItemMapper.toDTO(orderItem);
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Order-Item with order-id: " + orderItem.getId() + " doesn't exist between products."
        );
    }

    private void incrementExistingItemQuantity(OrderItem orderItem) {
        List<OrderItem> listOrders = orderItemRepo.findAllByAppUserAndProduct(orderItem.getAppUser().getId(), orderItem.getProduct().getId());
        for (OrderItem existingItem: listOrders) {
            if (orderItem.getProduct().getId().equals(existingItem.getProduct().getId())) {
                existingItem.setQuantity(
                        existingItem.getQuantity() + orderItem.getQuantity()
                );
            }
        }
    }

    public float getTotal(Long userId) {
        List<OrderItem> listOrders = orderItemRepo.findAllByAppUser(userId);
        float total = 0.0f;
        for (OrderItem orderItem : listOrders){
            int totalProduct = orderItem.getProduct().getProductPrise() * orderItem.getQuantity();
            total += totalProduct;
        }
        return total;
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
