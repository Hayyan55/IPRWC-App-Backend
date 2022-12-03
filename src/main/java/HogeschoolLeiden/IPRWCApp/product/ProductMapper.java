package HogeschoolLeiden.IPRWCApp.product;

import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDTO(Product product);

    Product toProduct(ProductDto productDto);

    List<ProductDto> toDTOs(List<Product> products);
}
