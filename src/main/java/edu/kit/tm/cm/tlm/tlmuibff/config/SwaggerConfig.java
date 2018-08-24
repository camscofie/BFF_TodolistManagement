package edu.kit.tm.cm.tlm.tlmuibff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact CONTACT = new Contact(
            "C&M", "https://cm.tm.kit.edu/", "cm-infrastruktur-admins@lists.kit.edu");

    private static final ApiInfo API_INFO = new ApiInfo(
            "TodoManagement Microservice", "Microservice for the TodoListManagement application managing the todo lists",
            "1.0", "urn:tos", CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());

    private static final Set<String> PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO)
                .produces(PRODUCES_AND_CONSUMES)
                .consumes(PRODUCES_AND_CONSUMES)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("edu.kit.tm.cm.tlm.tlmuibff.application"))
                .build();
    }
}
