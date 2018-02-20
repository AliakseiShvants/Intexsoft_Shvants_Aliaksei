package com.shvants.UrlShorter.exception;

import com.shvants.UrlShorter.domain.Link;

/**
 * <p>Customizing exception indicating that {@link Link} entity is absence in database.
 */
public class LinkNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5193151414420907564L;

    public LinkNotFoundException() {
        super("К сожалению, такую ссылку еще не сокращали. Вы можете быть первым!");
    }

}
