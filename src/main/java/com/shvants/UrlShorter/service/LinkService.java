package com.shvants.UrlShorter.service;

import com.shvants.UrlShorter.domain.Link;
import com.shvants.UrlShorter.domain.Tag;
import com.shvants.UrlShorter.repository.LinkRepo;
import com.shvants.UrlShorter.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Service class for link entity for working with repository interface
 *
 * @Transactional need for create-update operations.
 */
@Service
public class LinkService {

    @Autowired
    private LinkRepo linkRepo;

    public Link getLinkById(Integer id){
        return linkRepo.findById(id).get();
    }

    public Iterable<Link> getAllLinks(){
        return linkRepo.findAll();
    }

}
