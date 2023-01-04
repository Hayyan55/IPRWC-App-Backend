package HogeschoolLeiden.IPRWCApp.user;

import HogeschoolLeiden.IPRWCApp.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    AppUser findAppUserById(Long userId);
}
