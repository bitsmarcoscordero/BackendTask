package com.backend.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	 @Bean
	 public Docket usersApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	           .apiInfo(taskApiInfo())
	           .select()
	           .apis(RequestHandlerSelectors.any())
	           .build()
	           .useDefaultResponseMessages(false);
	 }

	 private ApiInfo taskApiInfo() {
	    return new ApiInfoBuilder()
	          .title("Backend Task")
	          .version("1.0")
	          .build();
	 }
}
