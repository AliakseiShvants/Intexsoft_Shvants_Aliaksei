package com.shvants.UrlShorter.controller;

//import com.shvants.UrlShorter.domain.Role;
import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * <p>Controller class for {@link User} entity.
 */

@RestController
@RequestMapping("api/users/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ReloadableResourceBundleMessageSource source;

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public User userById(@PathVariable Integer id){
        logger.info("you're inside userById method");
        return userService.getUserById(id);
    }

    /**
     * LOCALIZATION EXAMPLE!
     *
     * Access permission for user entity with role 'ADMIN'
     * @return
     */
    @GetMapping("admin/all")
    public Iterable<User> all(){
        logger.info("you're inside all method");

        String welcome = source.getMessage("message.welcome", new Object[]{"all"},
                new Locale("en", "EN"));
        System.out.println(welcome);

        String bye = source.getMessage("message.goodbye", new Object[]{"all"},
                new Locale("ru", "RU"));
        System.out.println(bye);

        return userService.getAllUsers();
    }

    /**
     * Access permission for user entity with role 'GUEST'
     * @param user
     * @return
     */
    @PostMapping(value = "register")
    public Boolean register(@RequestBody User user){
        logger.info("you're inside register method");
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
        logger.info("you're inside isExist method");
        return userService.getUserByLoginAndPassword(user.getLogin(), user.getPassword()) != null;
    }

}
