package com.shvants.UrlShorter.controller;

//import com.shvants.UrlShorter.domain.Role;
import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <p>Controller class for {@link User} entity.
 */

@RestController
@RequestMapping("api/users/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public User userById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    /**
     * Access permission for user entity with role 'ADMIN'
     * @return
     */
    @GetMapping("admin/all")
    public Iterable<User> all(){
        return userService.getAllUsers();
    }

    /**
     * Access permission for user entity with role 'GUEST'
     * @param user
     * @return
     */
    @PostMapping(value = "register")
    public Boolean register(@RequestBody User user){
        User newUser;
        if (userService.getUserByLoginAndPassword(user.getLogin(), user.getPassword()) == null){
            newUser = new User(user.getFullName(), user.getLogin(), user.getPassword(), user.getRole());
            userService.saveUser(newUser);
            return true;
        }
        return false;
    }

    /**
     *
     * @param user
     * @return true if user entity is exist in database and false otherwise
     */
    @PostMapping(value = "admin/exist")
    @ResponseBody
    public Boolean isExist(@RequestBody User user){
        return userService.getUserByLoginAndPassword(user.getLogin(), user.getPassword()) != null;
    }

}
