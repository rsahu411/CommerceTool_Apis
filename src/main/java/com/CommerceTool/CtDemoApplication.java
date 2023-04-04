package com.CommerceTool;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "CommerceTool Api",
				version = "1.0.0",
				description = "This project contaims commercetool apis",
				termsOfService = "runcodenow",
				contact = @Contact(
						name = "Mr Rishabh Sahu",
						email = "Rishabh.sahu@hybrisworld.com"
				),
				license = @License(
						name="licence",
						url = "runcodenow"
				)
		)
)
public class CtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtDemoApplication.class, args);
	}

}
