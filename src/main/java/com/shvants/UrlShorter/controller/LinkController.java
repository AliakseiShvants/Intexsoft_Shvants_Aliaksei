package com.shvants.UrlShorter.controller;

import com.shvants.UrlShorter.domain.Link;
import com.shvants.UrlShorter.exception.LinkNotFoundException;
import com.shvants.UrlShorter.repository.LinkRepo;
import com.shvants.UrlShorter.service.IdGenerator;
import com.shvants.UrlShorter.service.ShortUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping(value = "/link/shorter")
    @ResponseBody
    public Link shorterLink(@RequestBody Link link ){
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
