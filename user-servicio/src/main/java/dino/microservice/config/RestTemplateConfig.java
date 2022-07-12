package dino.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@Configuration
public class RestTemplateConfig {
	
	 @Bean // para poder inyectarlo
	 @LoadBalanced
		public RestTemplate restTemplate(){

			return new RestTemplate();
		}
	

}
