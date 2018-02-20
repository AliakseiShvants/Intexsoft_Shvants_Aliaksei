package com.shvants.UrlShorter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {
        "com.shvants.UrlShorter.controller",
        "com.shvants.UrlShorter.service"
})
@EnableJpaRepositories("com.shvants.UrlShorter.repository")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

}
