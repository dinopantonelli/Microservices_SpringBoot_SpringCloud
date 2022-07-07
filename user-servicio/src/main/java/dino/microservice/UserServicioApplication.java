package dino.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServicioApplication.class, args);
	}

}
