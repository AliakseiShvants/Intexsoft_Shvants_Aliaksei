package com.shvants.UrlShorter.controller;

import com.shvants.UrlShorter.domain.Link;
import com.shvants.UrlShorter.exception.LinkNotFoundException;
import com.shvants.UrlShorter.repository.LinkRepo;
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
    }

    @RequestMapping("/all")
    public Iterable<Link> getAll(){
        return linkRepo.findAll();
    }

//    @PostMapping(value = "/link/add")
//    @ResponseBody
//    public Boolean addLink(@RequestBody Link link){
//
//        Optional<Link> newlink = linkRepo.findByUrl(link.getUrl());
//        if (newlink == null){
//            linkRepo.save(link);
//            return true;
//        }
//        return false;
//    }

    @PostMapping(value = "/link/info")
    @ResponseBody
    public Link getUrl(@RequestBody Link lnk){
        Link link = linkRepo.findByUrl(lnk.getUrl());
        if (link != null){
            return link;
        } else {
            return new Link(0L);
        }
    }
}
