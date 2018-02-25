package com.shvants.UrlShorter.repository;

import com.shvants.UrlShorter.domain.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Access interface to {@link Link} entity in database
 */
@Repository
@Transactional
public interface LinkRepo extends CrudRepository<Link, Integer> {

   Link findByUrl(String url);

   Link findByShortUrl(String url);

}
