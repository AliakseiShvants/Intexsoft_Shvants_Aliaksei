package com.shvants.UrlShorter.service;

import com.shvants.UrlShorter.domain.Tag;
import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Service class for user entity for working with repository interface
 *
 * @Transactional need for create-update operations.
 */
@Service
public class TagService {

    @Autowired
    private TagRepo tagRepo;

    public Tag getTagById(Integer id){
        return tagRepo.findById(id).get();
    }

    public Iterable<Tag> getAllTags(){
        return tagRepo.findAll();
    }

}
