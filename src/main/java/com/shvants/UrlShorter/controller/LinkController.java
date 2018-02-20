package com.shvants.UrlShorter.controller;

import com.shvants.UrlShorter.domain.Link;
import com.shvants.UrlShorter.repository.LinkRepo;
import com.shvants.UrlShorter.util.IdGenerator;
import com.shvants.UrlShorter.util.ShortUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 */

@RestController
@RequestMapping("api/links")
public class LinkController {

    private final LinkRepo linkRepo;

    @Autowired
    public LinkController(LinkRepo linkRepo) {
        this.linkRepo = linkRepo;
        IdGenerator.initLinkId(linkRepo);
    }

    @RequestMapping("/all")
    public Iterable<Link> getAll(){
        return linkRepo.findAll();
    }

//    @PostMapping(value = "/link/find")
//    @ResponseBody
//    public Link findLink(@RequestBody String url){
//        Link link = linkRepo.findByUrl(url);
//        if (link != null){
//            return link;
//        } else {
//            return null;
//        }
//    }

    /**
     * Access permission for all user entities
     * @param link
     * @return
     */
    @PostMapping(value = "/link/shorter")
    @ResponseBody
    public Link shorterLink(@RequestBody Link link){
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
     * Access permission all user entities
     * @param url
     * @return
     */
    @PostMapping(value = "/link/info")
    @ResponseBody
    public Link getUrl(@RequestBody String url){
        Link link = linkRepo.findByShortUrl(url);
        if (link != null){
            return link;
        } else {
            return new Link( "c", "c", "c");
        }
    }


}
