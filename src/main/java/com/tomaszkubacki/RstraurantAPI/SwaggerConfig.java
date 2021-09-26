package com.tomaszkubacki.RstraurantAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Restaurant-api").description("REST API for Restaurant Info").version("1.0").build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tomaszkubacki.RestaurantAPI"))
                .build().apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfo(
                "Restaurant Api",
                "REST API for Restaurant Info",
                "1.0",
                "https://github.com/kubackiT/restaurant-api",
                new Contact("T.K", "https://github.com/kubackiT/restaurant-api", "test@test.com"),
                "free to use",
                "https://github.com/kubackiT/restaurant-api",
                Collections.emptyList()
        );
    }
}