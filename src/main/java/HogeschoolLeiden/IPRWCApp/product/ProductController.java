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
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RequestMapping("/products")
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

    @PostMapping("/add")
    public ResponseEntity<ProductDto> AddProduct(@RequestBody ProductDto productDto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/products/add").toUriString());
        return ResponseEntity.created(uri).body(productService.addProduct(productDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
