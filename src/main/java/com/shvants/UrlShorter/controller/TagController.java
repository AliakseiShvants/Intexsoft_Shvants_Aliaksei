package com.shvants.UrlShorter.controller;

import com.shvants.UrlShorter.domain.Tag;
import com.shvants.UrlShorter.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.shvants.UrlShorter.util.Constants.WELCOME;

/**
 * <p>Controller class for {@link Tag} entity.
 */

@RestController
@RequestMapping("api/tags/")
public class TagController {

    private static final Logger logger = LoggerFactory.getLogger(TagController.class);

    @Autowired
    private TagService tagService;

    /**
     * @return all {@link Tag} entities from database.
     */
    @GetMapping("/all")
    public Iterable<Tag> all(){
        logger.info(String.format(WELCOME, "all"));
        return tagService.getAllTags();
    }

    /**
     * @param id {@link Tag} entity identifier.
     *
     * @return {@link Tag} entity.
     */
    @GetMapping("{id}")
    public Tag tagById(@PathVariable Integer id){
        logger.info(String.format(WELCOME, "tagById"));
        return tagService.getTagById(id);
    }

}
