package com.product;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.product")
@EnableSwagger2
public class ProductDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDetailsApplication.class, args);
	}
	
	@Bean	
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)  
			          .select()                                  
			          .apis(RequestHandlerSelectors.any())              
			          .paths(PathSelectors.any())                          
			          .build();  
		}
	
	@Bean
	public Docket swaggerSpringMvcPlugin() {
	      return new Docket(DocumentationType.SWAGGER_2)
	              .groupName("api")
	              .select()
	              .paths(paths())
	              .build()
	              .apiInfo(apiInfo());
	  }

	  //Here is an example where we select any api that matches one of these paths
		private Predicate<String> paths() {
	      return or(regex("/productdetails/.*"),
	              regex("/productdetails.*"));
	  }

	  private ApiInfo apiInfo() {
	      return new ApiInfoBuilder()
	              .title("Product Details Microservice")
	              .description("Provides services to add Product Details and query Product data")
	              .version("2.0")
	              .termsOfServiceUrl("devopsinabox@newtglobal.com")
	              .build();
	  }
}