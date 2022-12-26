//package HogeschoolLeiden.IPRWCApp.order;
//
//import HogeschoolLeiden.IPRWCApp.orderItem.OrderItemDto;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@CrossOrigin
//@Slf4j
//@RequestMapping("/order_baskets")
//public class OrderController {
//    @Autowired
//    public OrderService orderService;
//
//    @GetMapping("")
//    public ResponseEntity<List<OrderDto>> getAllOrders() {
//        return ResponseEntity.ok().body(orderService.getAllOrdersDto());
//    }
//
//    @GetMapping("/{orderId}")
//    public ResponseEntity<OrderDto> getOrder(@PathVariable long orderId) {
//        return ResponseEntity.ok().body(orderService.getOrderDto(orderId));
//    }
//
////    @PostMapping("/add")
////    public ResponseEntity<List<OrderItemDto>> AddOrder(@RequestBody OrderItemDto orderItemDto) {
////        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/order_baskets/add").toUriString());
////        return ResponseEntity.created(uri).body(orderService.addItemToOrder(orderItemDto));
////    }
//
//    @DeleteMapping("/{orderId}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable long orderId) {
//        orderService.deleteOrder(orderId);
//        return ResponseEntity.ok().build();
//    }
//}
