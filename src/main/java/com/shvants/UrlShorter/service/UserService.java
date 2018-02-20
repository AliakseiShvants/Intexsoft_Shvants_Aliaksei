package com.shvants.UrlShorter.service;

import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Service class for user entity for working with repository interface
 *
 * @Transactional need for create-update operations.
 */
@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepo userRepo;

    public User getUserById(Integer id){
        return userRepo.findById(id).get();
    }

    public Iterable<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public List<User> getUsersByNameOrLogin(String name, String login){
        return userRepo.findByFullNameOrLogin(name, login);
    }

    public User getUserByLogin( String login){
        return userRepo.findByLogin(login);
    }

    public User getUserByLoginAndPassword(String login, String password){
        return userRepo.findByLoginAndPassword(login, password);
    }

    public User getUserByNameAndLoginOrPasswordOrderByFullNameDesc(String name, String login, String pass){
        return userRepo.findByFullNameAndLoginOrPasswordOrderByFullNameDesc(name, login, pass);
    }

    public List<User> getUserByLoginAndRole(String login, Integer role){
        return userRepo.findMyQuery(login, role);
    }

    public List<User> getUsersByLengthLoginAndPasswordOrderByFullName(){
        return entityManager.createQuery("select u from User u " +
                                                        "where length(u.login)+length(u.password) between 8 and 13 " +
                                                        "and u.login <> u.password " +
                                                        "order by u.fullName desc ", User.class)
                                        .getResultList();
    }

    public User getUserByUnhappyId(int id){
        return entityManager.createNamedQuery("unhappyId", User.class)
                                    .setParameter("id", id)
                                    .getSingleResult();
    }

    public User getUserByHappyId(int id){
        return entityManager.createNamedQuery("happyId", User.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    public List<User> getUsersByLengthOfPasswordGreater5(){
        return userRepo.findMyNativeQuery();
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsersByLoginLikeAndPasswordOrderByFullNameAndLengthOfLogin(String password){
        return (List<User>) entityManager.createNativeQuery(
                "SELECT * FROM webapp.users " +
                        "WHERE LOGIN LIKE ?1 AND PASSWORD LIKE ?2 " +
                        "ORDER BY FULLNAME, length(LOGIN)", User.class)
                                            .setParameter(1, "log%")
                                            .setParameter(2, password)
                                            .getResultList();
    }
}
