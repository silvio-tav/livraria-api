package com.example.biblioteca.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Cadastro de livros API")
                        .description("API Spring Boot RESTful usando springdoc-openapi e OpenAPI 3.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Dev Silvio Tavares")
                                ));
    }
}
