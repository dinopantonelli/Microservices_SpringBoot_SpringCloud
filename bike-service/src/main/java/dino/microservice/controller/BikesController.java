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


import dino.microservice.entity.Bikes;

import dino.microservice.service.BikesService;

@RestController
@RequestMapping("/bikes")
public class BikesController {
	
	
	  @Autowired
	  private BikesService bikesService;

	    @GetMapping()
	    public ResponseEntity<List<Bikes>> getAll() {
	        List<Bikes> bikes = bikesService.getAll();
	        if(bikes.isEmpty())
	            return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(bikes);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Bikes> getById(@PathVariable("id") int id) {
	        Bikes bike = bikesService.getBikesById(id);
	        if(bike == null)
	            return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(bike);
	    }

	    
	    @PostMapping()
	    public  ResponseEntity<Bikes> save(@RequestBody Bikes bike) {
	    	Bikes bikeNew = bikesService.save(bike);
	        return ResponseEntity.ok(bikeNew);
	    }
	     
	     
	    @GetMapping("/byuser/{userId}")
	    public ResponseEntity<List<Bikes>> getByUserId(@PathVariable("userId") int userId) {
	        List<Bikes> bikes = bikesService.byUserId(userId);
	        return ResponseEntity.ok(bikes);
	    }
	

}
