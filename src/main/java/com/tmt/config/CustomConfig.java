package com.tmt.config;

import org.springframework.context.annotation.*;
import org.springframework.data.projection.*;

@Configuration
public class CustomConfig {

    @Bean
    public ProjectionFactory projectionFactory() {
        return new SpelAwareProxyProjectionFactory();
    }
}
