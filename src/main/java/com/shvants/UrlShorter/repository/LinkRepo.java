package com.shvants.UrlShorter.repository;

import com.shvants.UrlShorter.domain.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepo extends CrudRepository<Link, Long> {

   Link findByUrl(String url);

   Link findByShortUrl(String url);
}
