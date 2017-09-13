package com.shvants.UrlShorter.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Link {

    private Long linkId;
    private String url;
    private String shortUrl;
    private String description;
    private AtomicInteger clickAmount;
    private List<Tag> tagList;

    public Link(String url) {
        this.url = url;
    }

    public Link(String url, String description) {
        this(url);
        this.description = description;
    }

    public Link(String url, Tag ... tags) {
        this(url);
        this.tagList = new ArrayList<>(Arrays.asList(tags));
    }

    public Link(String url, String description, Tag ... tags) {
        this(url, description);
        this.tagList = new ArrayList<>(Arrays.asList(tags));
    }
}
