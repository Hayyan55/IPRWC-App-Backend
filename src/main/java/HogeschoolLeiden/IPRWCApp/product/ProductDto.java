package HogeschoolLeiden.IPRWCApp.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long productId;
    private String productName;
    private String productPhoto;
    private int productPrise;
    private String productDescription;
}