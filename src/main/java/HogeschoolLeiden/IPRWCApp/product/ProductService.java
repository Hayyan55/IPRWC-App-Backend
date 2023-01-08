package HogeschoolLeiden.IPRWCApp.product;


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
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;
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

    public void deleteProduct(String username, String productName) {
        AppUser user = userRepo.findByUsername(username);
        Product product = productRepo.findByProductName(productName);
        if (user == null || !productRepo.existsById(product.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No product found with id: " + product.getId());
        }
        productRepo.deleteById(product.getId());
    }

    public ProductDto updateProduct(String productName, ProductDto productDto) {
        if (!productRepo.existsByProductName(productName)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No product found with id: " + productName);
        }
        Product product = productRepo.findByProductName(productName);
        product.setProductName(productDto.getProductName());
        product.setProductPrise(productDto.getProductPrise());
        product.setProductDescription(productDto.getProductDescription());
        return productMapper.toDTO(product);
    }
}
