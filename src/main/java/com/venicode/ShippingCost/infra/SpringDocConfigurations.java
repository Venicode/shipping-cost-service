package com.venicode.ShippingCost.infra;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Calculate Cost Shipping")
                        .description("This is a simple service that you can use to calculate the shipping cost to your delivery.")
                        .contact(new Contact()
                                .name("GitHub")
                                .url("https://github.com/Venicode")));

    }
}