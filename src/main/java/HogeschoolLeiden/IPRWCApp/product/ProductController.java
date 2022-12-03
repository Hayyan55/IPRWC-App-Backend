package HogeschoolLeiden.IPRWCApp.product;

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
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProductsDto());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProducts(@PathVariable long productId) {
        return ResponseEntity.ok().body(productService.getProductDto(productId));
    }

    @PostMapping("/product/add")
    public ResponseEntity<ProductDto> AddProduct(@RequestBody Product product) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/product/add").toUriString());
        return ResponseEntity.created(uri).body(productService.addProduct(product));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
