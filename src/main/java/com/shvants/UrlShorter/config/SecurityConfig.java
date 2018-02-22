package com.shvants.UrlShorter.config;

import com.shvants.UrlShorter.security.Roles;
import com.shvants.UrlShorter.security.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Locale;

@Configuration
@EnableWebSecurity
@ComponentScan("com.shvants.UrlShorter.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private final UserDetailsServiceImpl detailsService;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl detailsService) {
        this.detailsService = detailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder registry)
            throws Exception {
        registry.userDetailsService(detailsService).init(registry);
        logger.info("userDetailService is registered");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("inside httpSecurity configurer");
        http.authorizeRequests()
                .antMatchers("/api/users/admin/**").hasRole(Roles.ADMIN.name())
                .antMatchers("/api/links/all").hasAnyRole(Roles.USER.name(), Roles.GUEST.name())
                .antMatchers("/api/tags/all").hasRole(Roles.ADMIN.name())
                .and()
                .httpBasic();
        logger.info("http request is configure");
    }
}
