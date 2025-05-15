package com.poc.api_impl.webconfig;

import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.poc.api_impl.serviceImpl.CollegeServiceImpl;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CollegeServiceImpl.class);

    }

}
