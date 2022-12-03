package HogeschoolLeiden.IPRWCApp.user;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@Builder
@Table(name = "appUser")
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    private Collection<Role> roles = new ArrayList<>();
}
