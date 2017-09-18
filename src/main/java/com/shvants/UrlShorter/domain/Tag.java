package com.shvants.UrlShorter.domain;

import javax.persistence.*;

/**
 * Simple JB object that represents tag creating by {@link User } in {@link Link}
 */
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(name = "title")
    private String title;

    public Tag() {
    }

    public Tag(Long tagId) {
        this.tagId = tagId;
    }

    public Tag(String title) {
        this.title = title;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", title='" + title + '\'' +
                '}';
    }
}
