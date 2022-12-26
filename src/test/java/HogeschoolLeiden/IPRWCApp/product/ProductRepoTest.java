//package HogeschoolLeiden.IPRWCApp.product;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//
//@WebAppConfiguration
//@SpringBootTest
//@Rollback(value = false)
//class ProductRepoTest {
//
//    @Autowired
//    private ProductRepo productRepo;
//
//    @Test
//    void existsById() {
//        Product testProduct = Product.builder()
//                .productName("Hayyan")
//                .productPrise(123)
//                .build();
//        productRepo.existsById(testProduct.getId());
//    }
//
//    @Test
//    void findProductByProductName() {
//    }
//
//    @Test
//    void deleteProductByIdAndProductName() {
//    }
//}