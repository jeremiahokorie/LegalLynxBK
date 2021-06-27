package legallynx.com.controller;


import legallynx.com.impl.UserServiceImpl;
import legallynx.com.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@Slf4j
@RequestMapping("v1/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/")
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/")
    public List<User> get(){
        log.info("Logging for errors");
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id")  Long id ){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
       return ResponseEntity.ok(userService.deleteUserById(id)) ;

    }

}
