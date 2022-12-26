//package HogeschoolLeiden.IPRWCApp.order;
//
//import HogeschoolLeiden.IPRWCApp.orderItem.*;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//@AllArgsConstructor
//@Slf4j
//public class OrderService {
//    @Autowired
//    private OrderRepo orderRepo;
//    @Autowired
//    private OrderItemRepo orderItemRepo;
//
//    @Autowired
//    public OrderItemService orderItemService;
//    @Autowired
//    private OrderMapper orderMapper;
//    @Autowired
//    private OrderItemMapper orderItemMapper;
//
//    public List<OrderItemDto> addItemToOrder(OrderItemDto orderItemDto) {
////        OrderItemDto receivedOrderItemDto = orderItemService.addOrderItemToCart(orderItemDto);
//        log.info("Saving new order Item: {} to the database.", orderItemDto.getId());
//        OrderItem orderItem = orderItemMapper.toOrderItem(orderItemDto);
//        if (!order.getOrderItems().contains(orderItem)) {
//            order.getOrderItems().add(orderItem);
//            orderRepo.save(order);
//            return orderItemMapper.toDTOs(order.getOrderItems());
//        } else {
//            incrementExistingItemQuantity(order, orderItem);
//        }
//        return orderItemMapper.toDTOs(order.getOrderItems());
//    }
//
//    private static void incrementExistingItemQuantity(Order order, OrderItem orderItem) {
//        for (OrderItem existingItem: order.getOrderItems()) {
//            if (orderItem.getProduct().getId().equals(existingItem.getProduct().getId())) {
//                existingItem.setQuantity(
//                        existingItem.getQuantity() + orderItem.getQuantity()
//                );
//            }
//        }
//    }
//
//    public float getTotal(Order order) {
//        float total = 0.0f;
//        for (OrderItem orderItem:order.getOrderItems()){
//            int totalProduct = orderItem.getProduct().getProductPrise() * orderItem.getQuantity();
//            total += totalProduct;
//        }
//        return total;
//    }
//
//    public List<OrderDto> getAllOrdersDto() {
//        List<Order> orderList = orderRepo.findAll();
//        log.info(orderList.toString());
//        return orderMapper.toDTOs(orderList);
//    }
//
//    public OrderDto getOrderDto(Long id) {
//        Order order = getOrder(id);
//        return orderMapper.toDTO(order);
//    }
//
//    public Order getOrder(Long id) {
//        return orderRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
//
//    public void deleteOrder(Long id) {
//        if (!orderRepo.existsById(id)) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "No order found with id: " + id);
//        }
//        orderRepo.deleteById(id);
//    }
//}
