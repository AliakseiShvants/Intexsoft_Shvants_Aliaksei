package com.shvants.UrlShorter.service;

import com.shvants.UrlShorter.controller.UserController;
import com.shvants.UrlShorter.repository.UserRepo;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private static AtomicLong userIdGenerator;

    public static AtomicLong getUserIdGenerator() {
        return userIdGenerator;
    }

    public static void initUserId(UserRepo userRepo){
        userIdGenerator = new AtomicLong(userRepo.count());
    }
}
