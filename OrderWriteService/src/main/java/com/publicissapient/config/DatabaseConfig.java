package com.publicissapient.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration

@EnableSwagger2
public class DatabaseConfig {

    @Value("${couchbase.nodes}")
    private List<String> nodes = new ArrayList<String>();

    @Value("${couchbase.bucket}")
    private String bucket;

    @Value("${couchbase.password}")
    private String password;

    public List<String> getNodes() {
        return nodes;
    }

    public String getBucket() {
        return bucket;
    }

    public String getPassword() {
        return password;
    }
    @Bean
    public Docket orderApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 .apis(RequestHandlerSelectors.basePackage("com.publicissapient.controller"))
                .paths(regex("/order.*"))
                .build();
    }
}

