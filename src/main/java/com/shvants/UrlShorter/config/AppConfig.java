package com.shvants.UrlShorter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

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
    private boolean isShowSql;

    /**
     * <p>
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
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

    //TODO localization
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource() {
//        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
//        resource.setBasename("classpath:messages");
//        resource.setCacheSeconds(1);
//        resource.setDefaultEncoding("UTF-8");
//        return resource;
//    }
}
