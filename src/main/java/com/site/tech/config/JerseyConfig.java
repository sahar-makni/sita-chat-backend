package com.site.tech.config;

import com.site.tech.endpoint.UserEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(UserEndpoint.class);
    }
}