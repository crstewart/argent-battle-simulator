package com.argentstew.simulator.battle.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.web.config
 * 12/8/2021
 *
 * @author argen
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    private static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(
            Arrays.asList("js", "css", "ico", "json", "png", "jpg", "jpeg", "gif")
    );

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(FILE_EXTENSIONS.stream().map(extension -> "/**/*." + extension).toArray(String[]::new))
                .addResourceLocations("classpath:/static/")
                .resourceChain(true)
                .addResolver(getRelativeResolver());

        registry.addResourceHandler("/**/*")
                .addResourceLocations("classpath:/static/index.html")
                .resourceChain(true)
                .addResolver(getAbsoluteResolver());
    }

    private PathResourceResolver getRelativeResolver() {
        return new PathResourceResolver() {
            @Override
            protected Resource getResource(String resourcePath, Resource location) throws IOException {
                Resource requestedResource = location.createRelative(resourcePath);
                return requestedResource.exists() && requestedResource.isReadable() ? requestedResource : null;
            }
        };
    }

    private PathResourceResolver getAbsoluteResolver() {
        return new PathResourceResolver() {
            @Override
            protected Resource getResource(String resourcePath, Resource location) {
                return location.exists() && location.isReadable() ? location : null;
            }
        };
    }
}