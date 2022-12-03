package HogeschoolLeiden.IPRWCApp.user;

import HogeschoolLeiden.IPRWCApp.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}