package HogeschoolLeiden.IPRWCApp.user;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    //TODO: Delete it.
    List<AppUser>getUsers();
}
