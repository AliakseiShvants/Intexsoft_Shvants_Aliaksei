package com.shvants.UrlShorter.repository;

import com.shvants.UrlShorter.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findByFullNameOrLogin(String fullName, String login);

    User findByLoginAndPassword(String login, String password);



}
