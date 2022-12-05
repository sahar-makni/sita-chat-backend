package com.site.tech.config;

import com.site.tech.endpoint.SignInEndpoint;
import com.site.tech.endpoint.UserRessource;
import com.site.tech.filter.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(SignInEndpoint.class);
        register(UserRessource.class);
        register(CORSFilter.class);
        // TODO: add exception handler register
    }
}