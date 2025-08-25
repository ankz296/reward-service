package com.revinate.rewards.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI rewardsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Rewards API")
                        .description("API for calculating dynamic rewards across Hotel, Restaurant, and Casino")
                        .version("1.0.0"));
    }
}
