package dino.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsServiceApplication.class, args);
	}

}
