package com.shvants.UrlShorter.domain;

import com.fasterxml.jackson.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * <p>Simple JB object that represents {@link Link} entity creating by {@link User}
 */
@Entity
@Table(name = "LINKS")
@Component
@Scope("prototype")
public class Link implements Serializable{

    private static final long serialVersionUID = -8683364399653750124L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer linkId;

    @Column(name = "URL")
    private String url;

    @Column(name = "SHORT_URL")
    private String shortUrl;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CLICK_AMOUNT")
    private Integer clickAmount;

//    @JsonBackReference("user-link")
    @ManyToMany
    @JoinTable(name = "USERS_LINKS",
            joinColumns = {@JoinColumn(name = "LINK_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID")})
    private Set<User> linkUsers;

//    @JsonManagedReference("link-tag")
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "LINKS_TAGS",
            joinColumns = {@JoinColumn(name = "LINK_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TAG_ID")})
    private Set<Tag> linkTags;

    public Link() {
    }

    public Link(String url) {
        this.url = url;
    }

    public Link(String url, String shortUrl, String description) {
        this.url = url;
        this.shortUrl = shortUrl;
        this.description = description;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getClickAmount() {
        return clickAmount;
    }

    public void setClickAmount(Integer clickAmount) {
        this.clickAmount = clickAmount;
    }

    public Set<User> getLinkUsers() {
        return linkUsers != null ? new HashSet<>(linkUsers) : linkUsers;
    }

    public void setLinkUsers(Set<User> linkUsers) {
        if (linkUsers != null){
            this.linkUsers = new HashSet<>(linkUsers);
        }
        this.linkUsers = linkUsers;
    }

    public Set<Tag> getLinkTags() {
        return linkTags != null ? new HashSet<>(linkTags) : linkTags;
    }

    public void setLinkTags(Set<Tag> linkTags) {
        if (linkTags != null){
            this.linkTags = new HashSet<>(linkTags);
        }
        this.linkTags = linkTags;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", url='" + url + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", description='" + description + '\'' +
                ", clickAmount=" + clickAmount +
                '}';
    }

    @PostConstruct
    public void init() {
        System.out.println("link with url=" + this.url +" is constructed!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean type=" + this.url + " is destroyed!");
    }
}
