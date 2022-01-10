package com.example.esportsbackend.swaggerui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SpringFoxConfig {
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rsixesl.javafinal.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    @Bean
    public UiConfiguration uiConfiguration(){
        return UiConfigurationBuilder
                .builder()
                .defaultModelExpandDepth(-1)
                .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfo(
                "Esport Backend API",
                "This API was created as a project for the master's degree at UNIBUC. It aims to " +
                        "represent a platform where players can sign up to their favorite teams and " +
                        "play games, register their achievements, gain point, and see the schedule of " +
                        "their fave pro team",
                "version-1",
                "API TOS",
                "me@wherever.com",
                "API License",
                "API License URL"
        );
    }
}
