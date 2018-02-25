package com.shvants.UrlShorter.exception;

import com.shvants.UrlShorter.domain.User;
import com.shvants.UrlShorter.util.Constants;

/**
 * <p>Customizing exception indicating that {@link User} entity is absence in database.
 */
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 5193151414420907564L;

    public UserNotFoundException(String message) {

    }

}
