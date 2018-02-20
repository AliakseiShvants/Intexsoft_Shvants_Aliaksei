package com.shvants.UrlShorter.security;

import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getTitle());
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), Arrays.asList(authority));
    }
}
