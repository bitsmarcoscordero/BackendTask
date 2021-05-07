package com.backend.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.backend.task.config.SwaggerConfiguration;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class TaskApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
 
           registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");
 
    }
}
