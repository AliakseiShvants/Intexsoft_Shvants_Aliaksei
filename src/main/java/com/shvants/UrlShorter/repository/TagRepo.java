package com.shvants.UrlShorter.repository;

import com.shvants.UrlShorter.domain.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Access interface to {@link Tag} entity in database
 */
@Repository
@Transactional
public interface TagRepo extends CrudRepository<Tag, Integer> {

}
