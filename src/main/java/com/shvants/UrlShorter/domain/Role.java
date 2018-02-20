package com.shvants.UrlShorter.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p> Class that represents role of {@link User}
 */

@Entity
@Table(name = "ROLES")
@Component
@Scope("prototype")
public class Role implements Serializable{

    private static final long serialVersionUID = -1831927138303823326L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer roleId;

    @Column(name = "TITLE")
    private String title;

    @JsonBackReference("role")
    @OneToMany(mappedBy = "role")
    private Set<User> roleUsers;

    public Role() {
    }

    public Role(Integer roleId, String title) {
        this.roleId = roleId;
        this.title = title;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getRoleUsers() {
        return roleUsers != null ? new HashSet<>(roleUsers) : roleUsers;
    }

    public void setRoleUsers(Set<User> roleUsers) {
        if (roleUsers != null){
            this.roleUsers = new HashSet<>(roleUsers);
        }
        this.roleUsers = roleUsers;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", title='" + title + '\'' +
                '}';
    }
}
