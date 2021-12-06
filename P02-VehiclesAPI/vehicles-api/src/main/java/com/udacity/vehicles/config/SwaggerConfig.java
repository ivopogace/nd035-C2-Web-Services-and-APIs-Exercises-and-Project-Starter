package com.udacity.vehicles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    public static final Contact DEFAULT_CONTACT
            = new Contact(
            "Ivo Pogace",
            "https://github.com/ivopogace/nd035-C2-Web-Services-and-APIs-Exercises-and-Project-Starter",
            "ivopogace@gmail.com");
    public static final ApiInfo DEFAULT_API_INFO
            = new ApiInfo(
            "Vehicle API",
            "Spring Boot Vehicle API",
            "1.0",
            null,
            DEFAULT_CONTACT,
            "Copyright © 2012 - 2020, Udacity, Inc.",
            "https://github.com/ivopogace/nd035-C2-Web-Services-and-APIs-Exercises-and-Project-Starter/blob/master/LICENSE.txt",
            new ArrayList<>());
}

