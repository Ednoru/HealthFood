package com.example.healthfood.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .info(new Info().title("ISA Platform")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("ISA Platform Wiki Documentation"));

    }
}
