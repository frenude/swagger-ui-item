package com.frenude.swagger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author: Frenude
 * @mail: frenude@gmail.com
 * @date: created in 06 14,2021
 * @desc: //todo
 */
@Configuration
@EnableOpenApi
public class SwaggerConfiguration {

    public class SwaggerConfig {
        @Bean
        public Docket docket() {
            return new Docket(DocumentationType.OAS_30)
                    .apiInfo(new ApiInfoBuilder()
                            .title("API Documentation!")
                            .description("used knife4j swagger-bootstrap-ui to build")
                            .termsOfServiceUrl("https://github.com/frenude/swagger-ui-item")
                            .contact(new Contact("Frenude", "https://github.com/frenude/swagger-ui-item", "frenude@gmail.com"))
                            .version("1.0")
                            .build())
                    .groupName("OAS_30")
                    .select()
                    //加了ApiOperation注解的方法，才生成接口文档
                    // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                    //特定包下的类，才生成接口文档
                    .apis(RequestHandlerSelectors.basePackage("com.frenude.swagger.controller"))
                    .paths(PathSelectors.any())
                    .build();
        }
    }
}