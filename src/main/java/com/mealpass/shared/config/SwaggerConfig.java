package com.mealpass.shared.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI mealPassOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MealPass API")
                        .version("v1")
                        .description("MealPass REST API definition"));
    }
}
