package dino.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	 @Bean // para poder inyectarlo
		public RestTemplate restTemplate(){

			return new RestTemplate();
		}
	

}
