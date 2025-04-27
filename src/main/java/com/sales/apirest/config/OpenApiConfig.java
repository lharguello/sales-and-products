package com.sales.apirest.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String API_KEY_NAME = "x-api-key";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Sales")
                        .version("v2")
                        .description("REST API for sales and product management.")
                        .contact(new Contact()
                                .name("Luis H. Arguello")
                                .email("luis.arguello.caamal@gmail.com")
                        ))
                .addSecurityItem(new SecurityRequirement().addList(API_KEY_NAME))
                .components(new Components()
                        .addSecuritySchemes(API_KEY_NAME, new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.HEADER)
                                .name(API_KEY_NAME)));
    }
}
