package HogeschoolLeiden.IPRWCApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class IprwcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(IprwcAppApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Autowired
//	ProductRepo productRepo;
//	@Bean
//	CommandLineRunner run(UserService userService, ProductService productService) {
//		return args -> {
//			userService.saveRole(new Role(null,USER));
//			userService.saveRole(new Role(null,ADMIN));
//			userService.saveRole(new Role(null,SUPER_ADMIN));

//			userService.saveUser(new AppUser(null,"Hayyan Mezher", "Hayyan", "1324", new ArrayList<>()));
//			userService.saveUser(new AppUser(null,"Tomoka Shoji", "Tomo", "1234", new ArrayList<>()));
//			userService.saveUser(new AppUser(null,"Haruka Mezher", "Haruka", "4321", new ArrayList<>()));

//			userService.addRoleToUser("Hayyan", ADMIN);
//			userService.addRoleToUser("Tomo", SUPER_ADMIN);
//			userService.addRoleToUser("Haruka", USER);

//			Product product = new Product(null, "Karaage1", "", 123, "");
//			productRepo.save(product);
//			Product product1 = new Product(null, "Karaage2", "", 123, "");
//			productRepo.save(product1);
//			Product product2 = new Product(null, "Karaage3", "", 123, "");
//			productRepo.save(product2);
//			Product product3 = new Product(null, "Karaage4", "", 123, "");
//			productRepo.save(product3);
//			productService.addProduct(new Product(null, "Karaage", "", 123, ""));
//			productService.addProduct(new Product(null, "Karaage XL", "", 123, ""));
//			productService.addProduct(new Product(null, "Curry", "", 123, ""));
//			productService.addProduct(new Product(null, "Curry Tonkatsu", "", 123, ""));
//			productService.addProduct(new Product(null, "Curry Karaage", "", 123, ""));
//			productService.addProduct(new Product(null, "Miso Soup", "", 123, ""));
//			productService.addProduct(new Product(null, "Rice Burger", "", 123, ""));
//			productService.addProduct(new Product(null, "Tofu Salad", "", 123, ""));
//			productService.addProduct(new Product(null, "KaraMiso Set", "", 123, ""));
//			productService.addProduct(new Product(null, "Onigiri", "", 123, ""));
//		};
//	}
}
