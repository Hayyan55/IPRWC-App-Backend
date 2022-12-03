package HogeschoolLeiden.IPRWCApp.product;


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
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    private ProductMapper productMapper = new ProductMapperImpl();

    public ProductDto addProduct(Product product) {
        log.info("Saving new Product: {} to the database.", product.getProductName());
        if (!productRepo.existsByProductName(product.getProductName())) {
            product =Product.builder()
                    .productName(product.getProductName())
                    .productPhoto(product.getProductPhoto())
                    .productPrise(product.getProductPrise())
                    .productDescription(product.getProductDescription())
                    .build();
            productRepo.save(product);
            return productMapper.toDTO(product);
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Product with product id: " + product.getId() + " already exists"
        );
    }

    public List<ProductDto> getAllProductsDto() {
        List<Product> productList = productRepo.findAll();
        log.info(productList.toString());
        return productMapper.toDTOs(productList);
    }

    public ProductDto getProductDto(Long id) {
        Product product = getProduct(id);
        return productMapper.toDTO(product);
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public void deleteProduct(Long id) {
        if (!productRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No product found with id: " + id);
        }
        productRepo.deleteById(id);
    }
}
