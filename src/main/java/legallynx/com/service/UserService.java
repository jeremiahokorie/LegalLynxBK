package legallynx.com.service;


import legallynx.com.enums.ResponseCode;
import legallynx.com.exceptions.ServerExceptions;
import legallynx.com.impl.UserServiceImpl;
import legallynx.com.models.User;
import legallynx.com.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        if (user.getUserId() != null) {
            Optional<User> record = userRepository.findById(user.getUserId());
            if (record.isPresent()) {
                throw new ServerExceptions(ResponseCode.DUPLICATE_RECORD);
            }
        }
        Optional<User> user_rec = userRepository.findUserByEmail(user.getEmail());
        if (user_rec.isPresent()) {
            log.info("User already exist");
        }

        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        Optional<User> users = userRepository.findById(id);
        if (!users.isPresent()) {
            log.info("User with the Id does not exist");
            throw new ServerExceptions(ResponseCode.RECORD_NOT_FOUND);
        }
        return userRepository.findById(id);
    }

    public String deleteUserById(@PathVariable Long id) {
        Optional<User> record = userRepository.findById(id);
        if (record.isPresent()) {
            userRepository.deleteById(id);
            throw new ServerExceptions(ResponseCode.SUCCESS);
        } else {
            throw new ServerExceptions(ResponseCode.RECORD_NOT_FOUND);
        }
    }


}
