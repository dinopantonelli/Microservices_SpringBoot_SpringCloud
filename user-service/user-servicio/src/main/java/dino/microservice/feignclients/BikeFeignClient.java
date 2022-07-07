package dino.microservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dino.microservice.model.Bikes;


@FeignClient(name = "bike-service", url="http://localhost:8090")
@RequestMapping("/bikes")

public interface BikeFeignClient {
	
	@PostMapping()
    Bikes saveBikefromFeign(@RequestBody Bikes bike);
	
	
	@GetMapping("/byuser/{userId}")     
    List<Bikes> getBikes(@PathVariable("userId") int userId);    

}
