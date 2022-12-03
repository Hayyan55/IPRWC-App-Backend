package HogeschoolLeiden.IPRWCApp.product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name", columnDefinition = "TEXT", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_photo", columnDefinition = "TEXT")
    private String productPhoto;

    @Column(name = "product_prise", columnDefinition = "INT", nullable = false)
    private int productPrise;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;
}
