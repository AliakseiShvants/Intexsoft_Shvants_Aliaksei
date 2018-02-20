package com.shvants.UrlShorter.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Simple JB object that represents tag creating by {@link User } in {@link Link}
 */
@Entity
@Table(name = "TAGS")
@Component
@Scope("prototype")
public class Tag implements Serializable{

    private static final long serialVersionUID = 8939886430607951304L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer tagId;

    @Column(name = "TITLE")
    private String title;

//    @JsonBackReference("link-tag")
    @ManyToMany
    @JoinTable(name = "LINKS_TAGS",
            joinColumns = {@JoinColumn(name = "TAG_ID")},
            inverseJoinColumns = {@JoinColumn(name = "LINK_ID")})
    private Set<Link> tagLinks;

    public Tag() {
    }

    public Tag(Integer tagId) {
        this.tagId = tagId;
    }

    public Tag(String title) {
        this.title = title;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Link> getTagLinks() {
        return tagLinks != null ? new HashSet<>(tagLinks) : tagLinks;
    }

    public void setTagLinks(Set<Link> tagLinks) {
        if (tagLinks != null){
            this.tagLinks = new HashSet<>(tagLinks);
        }
        this.tagLinks = tagLinks;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", title='" + title +
                '}';
    }

    @PostConstruct
    public void init() {
        System.out.println("tag named=" + this.title +" is constructed!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean type=" + this.title + " is destroyed!");
    }
}
