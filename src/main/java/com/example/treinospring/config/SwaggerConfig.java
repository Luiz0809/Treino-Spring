package com.example.treinospring.config;

import com.example.treinospring.entidades.Cliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.websocket.ClientEndpointConfig;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket TreinoSpringApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.treinospring"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .ignoredParameterTypes(Cliente.class);
    }
        }



