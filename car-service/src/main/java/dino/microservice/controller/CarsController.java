package dino.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import dino.microservice.entity.Cars;
import dino.microservice.service.CarsService;

@RestController
@RequestMapping("/cars")
public class CarsController {
	
	
	  @Autowired
	  private CarsService carsService;

	    @GetMapping()
	    public ResponseEntity<List<Cars>> getAll() {
	        List<Cars> cars = carsService.getAll();
	        if(cars.isEmpty())
	            return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(cars);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Cars> getById(@PathVariable("id") int id) {
	        Cars car = carsService.getCarsById(id);
	        if(car == null)
	            return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(car);
	    }

	    
	    @PostMapping()
	    public  ResponseEntity<Cars> save(@RequestBody Cars car) {
	    	Cars carNew = carsService.save(car);
	        return ResponseEntity.ok(carNew);
	    }
	     
	     
	    @GetMapping("/byuser/{userId}")
	    public ResponseEntity<List<Cars>> getByUserId(@PathVariable("userId") int userId) {
	        List<Cars> cars = carsService.byUserId(userId);
	        return ResponseEntity.ok(cars);
	    }   
	

}
