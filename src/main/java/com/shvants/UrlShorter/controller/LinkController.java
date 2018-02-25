package com.shvants.UrlShorter.controller;

import com.shvants.UrlShorter.domain.Link;
import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.repository.LinkRepo;
import com.shvants.UrlShorter.util.IdGenerator;
import com.shvants.UrlShorter.util.ShortUrlGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.shvants.UrlShorter.util.Constants.WELCOME;

/**
 * <p>Controller class for {@link Link} entity.
 */

@RestController
@RequestMapping("api/links")
public class LinkController {

    private static final Logger logger = LoggerFactory.getLogger(LinkController.class);

    private final LinkRepo linkRepo;

    @Autowired
    public LinkController(LinkRepo linkRepo) {
        this.linkRepo = linkRepo;
        IdGenerator.initLinkId(linkRepo);
    }

    /**
     * @return all {@link Link} entities from database.
     */
    @GetMapping("/all")
    public Iterable<Link> getAll(){
        logger.info(String.format(WELCOME, "all"));
        return linkRepo.findAll();
    }

//    @PostMapping(value = "/link/find")
//    public Link findLink(@RequestBody String url){
//        Link link = linkRepo.findByUrl(url);
//        if (link != null){
//            return link;
//        } else {
//            return null;
//        }
//    }

    /**
     * Access permission for all {@link User} entities
     * @param link entity that url must be shorten.
     *
     * @return {@link Link} entity with short url.
     */
    @PostMapping(value = "/link/shorter")
    public Link shorterLink(@RequestBody Link link){
        logger.info(String.format(WELCOME, "shorterLink"));
        Link lookedLink = linkRepo.findByUrl(link.getUrl());
        if (lookedLink == null){
            Long id = IdGenerator.getLinkIdGenerator().incrementAndGet();
            String shortUrl = ShortUrlGenerator.generateShortUrl(id);
            Link newLink = new Link(link.getUrl(), shortUrl, link.getDescription());
            linkRepo.save(newLink);
            return newLink;
        }
        return null;
    }

    /**
     * Access permission all {@link User} entities
     * @param url
     *
     * @return link entity that has @param url as url.
     */
    @PostMapping(value = "/link/info")
    public Link linkByUrl(@RequestBody String url){
        logger.info(String.format(WELCOME, "linkByUrl"));
        Link link = linkRepo.findByShortUrl(url);
        if (link != null){
            return link;
        } else {
            return new Link( "c", "c", "c");
        }
    }
}
