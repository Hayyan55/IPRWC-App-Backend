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
    @Autowired
    private ProductMapper productMapper;

    public ProductDto addProduct(ProductDto productDto) {
        log.info("Saving new Product: {} to the database.", productDto.getProductName());
        String productName = productDto.getProductName();
        if (!productRepo.existsByProductName(productName)) {
            Product product = productMapper.toProduct(productDto);
            productRepo.save(product);
            return productMapper.toDTO(product);
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Product with product id: " + productDto.getProductName() + " already exists"
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

    private Product getProduct(Long id) {
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
