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

    @GetMapping("/{username}/all")
    public ResponseEntity<List<OrderItemDto>> getAllOrderItems(@PathVariable String username) {
        return ResponseEntity.ok().body(orderItemService.getAllOrderItemsDto(username));
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

    @GetMapping("/order-item/{username}/total")
    public ResponseEntity<Float> getTotal(@PathVariable String username) {
        return ResponseEntity.ok().body(orderItemService.getTotal(username));
    }

    @DeleteMapping("/{username}/delete/{productName}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable String username, @PathVariable String productName) {
        orderItemService.deleteOrderItem(username, productName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{username}/submit")
    public ResponseEntity<Void> SubmitAllItems(@PathVariable String username) {
        orderItemService.submitAll(username);
        return ResponseEntity.ok().build();
    }
}
