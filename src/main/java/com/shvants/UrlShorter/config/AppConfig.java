package com.shvants.UrlShorter.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.sql.DataSource;
import java.util.Locale;

/**
 * <p>Class that provides a configuration to the application context
 */
@Configuration
@PropertySources(value = {
        @PropertySource("classpath:application.properties")
        })
@EnableTransactionManagement
@Import(value = {SecurityConfig.class, WebMvcConfig.class})
public class AppConfig {

    private final static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Value("${spring.datasource.driver}")
    private String databaseDriver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.schema}")
    private String schema;

    @Value("${spring.datasource.user}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String generatedDdl;

    @Value("${spring.jpa.show-sql}")
    private Boolean isShowSql;

    @Value("${spring.messages.baseName}")
    private String messageSourceName;

    @Value("${spring.messages.encoding}")
    private String encoding;

    @Value("${spring.messages.cacheSeconds}")
    private Integer cacheSeconds;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * <p>
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        logger.info("inside in data source");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseDriver);
        dataSource.setSchema(schema);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * <p>Customizing a specific implementation of JPA.
     *
     * @return JPA adapter class
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        logger.info("inside in jpa adapter");
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setShowSql(isShowSql);
//        jpaVendorAdapter.setGenerateDdl(generatedDdl);
        return jpaVendorAdapter;
    }

    /**
     * <p>Create EntityManagerFactory factory managed by the container.
     *
     * @return a specific factory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        logger.info("inside in entity manager factory");
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(jpaVendorAdapter());
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.shvants.UrlShorter.domain");
        return factory;
    }

    /**
     * @return JPA transaction manager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    /**
     * Localization
     * @return
     */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        logger.info("inside in resource bundle creator");

        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasenames(messageSourceName);

        resource.setUseCodeAsDefaultMessage(true);
        resource.setFallbackToSystemLocale(false);

        resource.setCacheSeconds(cacheSeconds);
        resource.setDefaultEncoding(encoding);

        logger.info("resource bundle is configured");
        return resource;
    }

    @Bean
    public LocaleResolver localeResolver(){
        logger.info("inside in locale resolver");
        SessionLocaleResolver r = new SessionLocaleResolver();
        r.setDefaultLocale(new Locale("en", "EN"));
        return r;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        logger.info("inside in locale change interceptor");
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        return lci;
    }

    @Bean
    public HandlerMapping handlerMapping(){
        logger.info("inside in handle mapping");
        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
        handlerMapping.setInterceptors(localeChangeInterceptor());
        return handlerMapping;
    }
}
