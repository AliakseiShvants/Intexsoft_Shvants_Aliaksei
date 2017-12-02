package com.shvants.UrlShorter.exception;

public class LinkNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5193151414420907564L;

    public LinkNotFoundException() {
        super("К сожалению, такую ссылку еще не сокращали. Вы можете быть первым!");
    }

}
