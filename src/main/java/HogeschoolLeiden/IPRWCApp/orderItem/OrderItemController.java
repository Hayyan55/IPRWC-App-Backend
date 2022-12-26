package HogeschoolLeiden.IPRWCApp.orderItem;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("")
    public ResponseEntity<List<OrderItemDto>> getAllOrderItems() {
        return ResponseEntity.ok().body(orderItemService.getAllOrderItemsDto());
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<OrderItemDto> getOrderItem(@PathVariable Long itemId) {
        return ResponseEntity.ok().body(orderItemService.getOrderItemDto(itemId));
    }

    @PostMapping("/order-item/add")
    public ResponseEntity<OrderItemDto> addItemToOrderCart(@RequestBody OrderItemDto orderItemDto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/order-item/add").toUriString());
        return ResponseEntity.created(uri).body(orderItemService.addProductToCart(orderItemDto));
    }

    @GetMapping("/order-item/{userId}/total")
    public ResponseEntity<Float> getTotal(@PathVariable Long userId) {
        return ResponseEntity.ok().body(orderItemService.getTotal(userId));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long itemId) {
        orderItemService.deleteOrderItem(itemId);
        return ResponseEntity.ok().build();
    }
}
