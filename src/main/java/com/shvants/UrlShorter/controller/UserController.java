package com.shvants.UrlShorter.controller;

import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.service.UserService;
import com.shvants.UrlShorter.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static com.shvants.UrlShorter.util.Constants.GOODBYE;
import static com.shvants.UrlShorter.util.Constants.WELCOME;

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
        logger.info(WELCOME);
        return userService.getUserById(id);
    }

    /**
     * LOCALIZATION EXAMPLE!
     *
     * <p>Access permission for {@link User} entity with role 'ADMIN'
     *
     * @return all {@link User} entities from database.
     */
    @GetMapping("admin/all")
    public Iterable<User> all(){
        logger.info(String.format(WELCOME, "all"));

        String welcome = source.getMessage("message.welcome", new Object[]{"all"},
                new Locale("en", "EN"));
        System.out.println(welcome);

        String bye = source.getMessage("message.goodbye", new Object[]{"all"},
                new Locale("ru", "RU"));
        System.out.println(bye);

        logger.info(String.format(GOODBYE, "all"));
        return userService.getAllUsers();
    }

    /**
     * <p>Access permission for {@link User} entity with role 'GUEST'
     * @param user entity
     *
     * @return true if new {@link User} entity is successfully register and
     * false if {@link User} entity has been already registered.
     */
    @PostMapping(value = "register")
    public Boolean register(@RequestBody User user){
        logger.info(String.format(WELCOME, "register"));
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
     * @param user {@link User} entity
     * @return true if {@link User} entity is exist in database and false otherwise
     */
    @PostMapping(value = "admin/exist")
    @ResponseBody
    public Boolean isExist(@RequestBody User user){
        logger.info(String.format(WELCOME, "isExist"));
        return userService.getUserByLoginAndPassword(user.getLogin(), user.getPassword()) != null;
    }

}
