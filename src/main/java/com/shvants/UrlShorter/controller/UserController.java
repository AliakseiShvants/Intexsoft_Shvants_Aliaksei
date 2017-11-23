package com.shvants.UrlShorter.controller;

import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userRepo.findOne(userId);
    }

    @RequestMapping("/all")
    public Iterable<User> getAll(){
        return userRepo.findAll();
    }

    @RequestMapping("/getMockUser")
    public User getUser(
            @RequestParam(value = "userId", defaultValue = "1") Long id,
            @RequestParam(value = "username", defaultValue = "Aliaksei Shvants") String fullName,
            @RequestParam(value = "email", defaultValue = "email@gmail.com") String email,
            @RequestParam(value = "password", defaultValue = "1111") String password){
        return new User(id, fullName, email, password);
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public Boolean register(@RequestBody User newUser){
        List<User> userList = userRepo.findByFullNameOrLogin(newUser.getFullName(), newUser.getLogin());
        if (userList.isEmpty()){
            userRepo.save(newUser);
            return true;
        }
        return false;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Boolean login(@RequestBody User user){
        User loggedUser = userRepo.findByLogin(user.getLogin());
        return loggedUser != null;
    }
}
