package br.cin.ufpe.sdpos.mpback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.cin.ufpe.sdpos.mpback.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Maria da Penha Back API",
                "Backend do servico desenvolvido para disciplina de sistemas distribuidos 2019.1 CIN-UFPE.",
                "1.0.0",
                "Terms of service",
                contato(),
                "License of API", "API license URL", Collections.emptyList());
    }

    private Contact contato() {

        return new Contact(
                "SD POS",
                "https://github.com/sdpos20191/mariadapenhabackend",
                "sdpos20191@cin.ufpe.br");
    }
}
