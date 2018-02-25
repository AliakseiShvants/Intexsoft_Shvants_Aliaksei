package com.shvants.UrlShorter.domain;

import com.fasterxml.jackson.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Simple JavaBean domain object that represents a User entity.
 */

@Entity
@Table(name = "USERS")
@Component
@Scope("prototype")
@NamedQueries({
        @NamedQuery(name = "unhappyId",
                query = "select u from User u " +
                        "where u.userId = :id")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "happyId",
                query = "SELECT * FROM webapp.users WHERE id = ?1",
                resultClass = User.class)
})
public class User implements Serializable {

    private static final long serialVersionUID = -8854389934589673010L;
    private final static Logger logger = LoggerFactory.getLogger(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer userId;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @JsonManagedReference("role")
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

//    @JsonManagedReference("user-link")
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "USERS_LINKS",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "LINK_ID")})
    private Set<Link> userLinks;

    public User() { }

    public User(String fullName, String login, String password, Role role) {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User(Integer id, String fullName, String login, String password, Role role) {
        this(fullName, login, password, role);
        this.userId = id;
    }


    public User(String fullName) {
        this.fullName = fullName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Link> getUserLinks() {
        return userLinks != null ? new HashSet<>(userLinks) : userLinks;
    }

    public void setUserLinks(Set<Link> usersLinks) {
        if (usersLinks != null){
            this.userLinks = new HashSet<>(usersLinks);
        }
        this.userLinks = usersLinks;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
