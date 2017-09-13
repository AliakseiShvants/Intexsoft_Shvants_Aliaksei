package com.shvants.UrlShorter.entities;

public class Tag {

    private Long tagId;
    private String title;

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
}
