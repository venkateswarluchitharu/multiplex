package com.multiplex.swaggerconfig;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.multiplex.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Multiplex API", //title
                "do some basic operations like  adding, deleting, updating, searching Multiplex. multiplex API Produce Application/Json or Application/Xml formate of data. ",  //description
                "Version 1.0", //version
                "Terms of service", //terms of service URL
                new Contact("venkateswarlu chitharu", "www.example.com", "cvenkat@company.com"),
                "License of API", "API license URL", Collections.emptyList()); // multiplex info
    }
}