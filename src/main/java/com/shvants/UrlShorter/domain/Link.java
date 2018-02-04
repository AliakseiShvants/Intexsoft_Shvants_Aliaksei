package com.shvants.UrlShorter.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Simple JB object that represents link creating by {@link User}
 */
@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;

    @Column(name = "url")
    private String url;

    @Column(name = "shortUrl")
    private String shortUrl;

    @Column(name = "description")
    private String description;

//    //TODO it is right?
//    @JoinTable(name = "statistics", joinColumns = @JoinColumn(name = "amount"))
//    private AtomicInteger clickAmount;
//
//    //TODO it's that right too?
//    @ManyToMany
//    @JoinTable(name = "tags", joinColumns = @JoinColumn(name = "id"),
//    inverseJoinColumns = @JoinColumn(name = "title"))
//    private List<Tag> tagList;

    public Link() {
    }


    public Link(String url, String shortUrl, String description) {
        this.url = url;
        this.shortUrl = shortUrl;
        this.description = description;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
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

//    public AtomicInteger getClickAmount() {
//        return clickAmount;
//    }

//    public void setClickAmount(AtomicInteger clickAmount) {
//        this.clickAmount = clickAmount;
//    }

//    public List<Tag> getTagList() {
//        return tagList;
//    }

//    public void setTagList(List<Tag> tagList) {
//        this.tagList = tagList;
//    }


}
