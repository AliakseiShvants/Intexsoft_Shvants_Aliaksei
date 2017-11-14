package com.shvants.UrlShorter.repository;

import com.shvants.UrlShorter.domain.User;
import org.hibernate.mapping.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    Optional<User> findByUserId(Long id);


}
