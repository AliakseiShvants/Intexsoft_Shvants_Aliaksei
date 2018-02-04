package com.shvants.UrlShorter.controller;

import com.shvants.UrlShorter.domain.Link;
import com.shvants.UrlShorter.domain.Role;
import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.repository.UserRepo;
import com.shvants.UrlShorter.service.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
        IdGenerator.initUserId(this.userRepo);
    }

    @RequestMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userRepo.findOne(userId);
    }

    @RequestMapping("/all")
    public Iterable<User> getAll(){
        return userRepo.findAll();
    }

//    @RequestMapping("/getMockUser")
//    public User getUser(
//            @RequestParam(value = "userId", defaultValue = "1") Long id,
//            @RequestParam(value = "username", defaultValue = "Aliaksei Shvants") String fullName,
//            @RequestParam(value = "email", defaultValue = "email@gmail.com") String email,
//            @RequestParam(value = "password", defaultValue = "1111") String password){
//        return new User(id, fullName, email, password);
//    }

    @PostMapping(value = "/register")
    @ResponseBody
    public Boolean register(@RequestBody User user){
        List<User> userList = userRepo.findByFullNameOrLogin(user.getFullName(), user.getLogin());
        if (userList.isEmpty()){
            User newUser = new User(user.getFullName(), user.getLogin(), user.getPassword(), Role.USER.name());
            userRepo.save(newUser);
            return true;
        }
        return false;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Boolean login(@RequestBody User user){
        User loggedUser = userRepo.findByLoginAndPassword(user.getLogin(), user.getPassword());
        return loggedUser != null;
    }

}
