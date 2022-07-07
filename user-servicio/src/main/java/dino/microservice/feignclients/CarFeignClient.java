package dino.microservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dino.microservice.model.Cars;

@FeignClient(name = "car-service", url="http://localhost:8089")
@RequestMapping("/cars")

public interface CarFeignClient {
	
	@PostMapping()
    Cars saveCarfromFeign(@RequestBody Cars car);
	
	
	@GetMapping("/byuser/{userId}")     
    List<Cars> getCars(@PathVariable("userId") int userId);   
	

}
