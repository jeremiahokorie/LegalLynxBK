package legallynx.com.impl;


import legallynx.com.models.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserServiceImpl {
    public User saveUser(User user);
    public List<User> getAllUser();
    public Optional<User> getUserById(Long id);
    public String deleteUserById(@PathVariable Long id);

//    public List<User> deleteAll();
}
