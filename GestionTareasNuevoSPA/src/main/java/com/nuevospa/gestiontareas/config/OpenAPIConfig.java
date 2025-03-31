package com.nuevospa.gestiontareas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Desafío Técnico")
                        .version("1.0")
                        .description("API para la gestión de tareas de la empresa NUEVO SPA")
                        .contact(new Contact()
                                .name("Omar Vergara")
                                .email("omarvergarazamorano@gmail.com")));
    }
}