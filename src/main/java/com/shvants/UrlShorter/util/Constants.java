package com.shvants.UrlShorter.util;

public class Constants {
    public static final String APP_PROP = "classpath:application.properties";
    public static final String DRIVER = "spring.datasource.driver";
    public static final String URL = "spring.datasource.url";
    public static final String SCHEMA = "spring.datasource.schema";
    public static final String USER = "spring.datasource.user";
    public static final String PASSWORD = "spring.datasource.password";
    public static final String DIALECT = "spring.jpa.properties.hibernate.dialect";
    public static final String DDL_AUTO = "spring.jpa.hibernate.ddl-auto";
    public static final String SHOW_SQL = "spring.jpa.show-sql";
    public static final String SERVLET_NAME = "dispatcher";
    public static final String URL_PATTERN = "/";
    public static final String ENTITIES = "com.shvants.UrlShorter.domain";
    public static final String MESSAGE_SOURCE_NAME = "spring.messages.baseName";
    public static final String ENCODING = "spring.messages.encoding";
    public static final String CACHE_SECONDS = "spring.messages.cacheSeconds";
    public static final String DEFAULT_LANG = "en";
    public static final String DEFAULT_COUNTRY = "EN";
    public static final String CONTROLLERS = "com.shvants.UrlShorter.controller";
    public static final String SERVICES = "com.shvants.UrlShorter.service";
    public static final String REPOSITORIES = "com.shvants.UrlShorter.repository";
    public static final String SECURITY = "com.shvants.UrlShorter.security";
    public static final String WELCOME = "Method %s is running!";
    public static final String GOODBYE = "Method %s is finished!";
    public static final String UNFE_MESSAGE = "Пользователь с таким логином отсутствует в нашей базе";
}
