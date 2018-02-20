package com.shvants.UrlShorter.util;

import com.shvants.UrlShorter.repository.LinkRepo;
import com.shvants.UrlShorter.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
public class IdGenerator {

    private static AtomicLong userIdGenerator;
    private static AtomicLong linkIdGenerator;

    public static void initUserId(UserRepo userRepo){
        userIdGenerator = new AtomicLong(userRepo.count());
    }

    public static void initLinkId(LinkRepo linkRepo){
        linkIdGenerator = new AtomicLong(linkRepo.count());
    }

    public static AtomicLong getUserIdGenerator() {
        return userIdGenerator;
    }

    public static AtomicLong getLinkIdGenerator() {
        return linkIdGenerator;
    }
}
