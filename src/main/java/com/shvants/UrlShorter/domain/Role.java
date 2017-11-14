package com.shvants.UrlShorter.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Simple JB object that represents role of {@link User}
 */

@Entity
@Table(name = "roles")
public class Role implements Serializable{

    private static final long serialVersionUID = 5530737771243918379L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo enum
    @Column(name = "role")
    private String role;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
