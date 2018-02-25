package com.shvants.UrlShorter.security;

import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.exception.UserNotFoundException;
import com.shvants.UrlShorter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.shvants.UrlShorter.util.Constants.UNFE_MESSAGE;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) {
        User user = userService.getUserByLogin(login);
        try {
            if (user == null){
                throw new UserNotFoundException(UNFE_MESSAGE);
            }
            if (user.getRole() == null || user.getLogin() == null || user.getPassword() == null){
                throw new NullPointerException("У пользователя отсутствует необходимый параметр(логин, пароль, роль)");
            }
        }catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getTitle());
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), Arrays.asList(authority));
    }
}
