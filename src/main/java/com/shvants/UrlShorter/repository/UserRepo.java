package com.shvants.UrlShorter.repository;

import com.shvants.UrlShorter.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQuery;
import java.util.List;
/**
 * Access interface to user entity in database
 *
 * @Transactional need for create-update operations.
 */
@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    List<User> findByFullNameOrLogin(String fullName, String login);

    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);

    User findByFullNameAndLoginOrPasswordOrderByFullNameDesc(String name, String login, String password);

    @Query("select u from User u " +
            "where u.login = :login " +
                "and u.role = :role")
    List<User> findMyQuery(@Param("login") String login, @Param("role") Integer role);

    @Query(value = "SELECT * FROM webapp.users " +
                    "WHERE length(password) > 5", nativeQuery = true)
    List<User> findMyNativeQuery();
}
