package org.yarik.testTask.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI().
                info(new Info().
                        title("Test task. RESTfull Service for Innowise").
                        version("1.0.0")
                );
    }
}