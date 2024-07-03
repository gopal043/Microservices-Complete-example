package com.xtglobal.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs",
				description = "Department Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
					      name = "Gopal",
					      email = "gopal@gmail.com",
					      url = "https://www.gopal.com"
				),
				license = @License(
				         name = "Apache 2.0",
				         url = "https://www.apache.com"
				)
		),
		externalDocs = @ExternalDocumentation(
		               description = "Department-service doc",
		               url = "https://www.gopal.com"
	    )
)

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
