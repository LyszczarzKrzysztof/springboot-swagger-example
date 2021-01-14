package com.example.springbootswaggerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringbootSwaggerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwaggerExampleApplication.class, args);
    }

    /**
     * wybor api, ktore chcemy udostepnic w swagger dla potencjalnych uzytkownikow
     * poprzez wyszczegolniony endpoint
     * poprzez wyszczegolniony package
     * przypadek ponizej dziala jak ampersand - czyli zwroci czesc wspolna obydwu zbiorow
     * */
    @Bean
    public Docket get(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootswaggerexample"))
                .build()
                .apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfo("Students API",
                "Student DB",
                "1.00",
                "http://example.com",
                new Contact("Krzysiek", "http://example.com", "krzysiek@example.com"),
                "my licence",
                "http://example.com",
                Collections.emptyList());
    }
}
