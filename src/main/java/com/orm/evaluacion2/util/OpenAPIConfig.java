package com.orm.evaluacion2.util;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Evaluación 2")
                        .version("1.0")
                        .description("Documentación de la API para la evaluación 2 de ORM"))
                .tags(List.of(
                        new Tag().name("Customer").description("Operaciones relacionadas con los clientes"),
                        new Tag().name("Product").description("Operaciones relacionadas con los productos"),
                        new Tag().name("Order").description("Operaciones relacionadas con las órdenes"),
                        new Tag().name("Delivery").description("Operaciones relacionadas con las entregas"),
                        new Tag().name("Category").description("Operaciones relacionadas con las categorías")
                ));
    }
}
