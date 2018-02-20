package com.shvants.UrlShorter.controller;

import com.shvants.UrlShorter.domain.Tag;
import com.shvants.UrlShorter.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 */

@RestController
@RequestMapping("api/tags/")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/all")
    public Iterable<Tag> all(){
        return tagService.getAllTags();
    }

    @GetMapping("{id}")
    public Tag tagById(@PathVariable Integer id){
        return tagService.getTagById(id);
    }

}
