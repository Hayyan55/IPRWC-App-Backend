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
@CrossOrigin(origins = "*")
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
    public ResponseEntity<ProductDto> getProduct(@PathVariable long productId) {
        return ResponseEntity.ok().body(productService.getProductDto(productId));
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> AddProduct(@RequestBody ProductDto productDto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/products/add").toUriString());
        return ResponseEntity.created(uri).body(productService.addProduct(productDto));
    }

    @PutMapping("/update/{productName}")
    public ResponseEntity<ProductDto> updateProduct (
    @PathVariable String productName,
    @RequestBody ProductDto productDto) {
        return ResponseEntity.ok().body(productService.updateProduct(productName, productDto));
    }

    @DeleteMapping("/{username}/delete/{productName}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String username, @PathVariable String productName) {
        productService.deleteProduct(username, productName);
        return ResponseEntity.ok().build();
    }
}
