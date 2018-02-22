package com.shvants.UrlShorter.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@Component
public class WebConfig implements WebApplicationInitializer {

    private static final String SERVLET_NAME = "dispatcher";
    private static final String URL_PATTERN = "/";
    private final static Logger logger = LoggerFactory.getLogger(WebConfig.class);

    /**
     * <p>Create the 'root' Spring application context
     * manage the lifecycle of the 'root' application context by creating in servlet context a new listener
     * create the dispatcher servlet's Spring application context
     * register and map the dispatcher servlet
     * note Dispatcher servlet with constructor arguments
     *
     * @param servletContext
     */
    @Override
    public void onStartup(ServletContext servletContext) {
        logger.info("inside onStartup method");

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);

        servletContext.addListener(new ContextLoaderListener(appContext));
        appContext.setServletContext(servletContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(SERVLET_NAME,
                new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(URL_PATTERN);

        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter",
                new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
    }
}
