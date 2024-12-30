package com.example.pricing.infrastructure.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Swagger configuration for the Pricing API */
@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI(
      @Value("${spring.application.name}") final String appName,
      @Value("${application.description}") final String appDescription,
      @Value("${application.version}") String appVersion) {

    return new OpenAPI()
        .info(new Info().title(appName).description(appDescription).version(appVersion));
  }
}
