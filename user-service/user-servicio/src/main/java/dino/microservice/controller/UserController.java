package dino.microservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import dino.microservice.entity.Users;
import dino.microservice.model.Bikes;
import dino.microservice.model.Cars;
import dino.microservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	  @Autowired
	  private UserService userService;

	    @GetMapping()
	    public ResponseEntity<List<Users>> getAll() {
	        List<Users> users = userService.getAll();
	        if(users.isEmpty())
	            return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(users);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Users> getById(@PathVariable("id") int id) {
	        Users user = userService.getUserById(id);
	        if(user == null)
	            return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(user);
	    }

	    
	    @PostMapping()
	    public  ResponseEntity<Users> save(@RequestBody Users user) {
	    	
	    	//System.out.println(user.getname)
	        Users userNew = userService.save(user);
	        return ResponseEntity.ok(userNew);
	        
	        
	    }
	     
	     
	    @GetMapping("/cars/{userId}")                                          // ojo el endpoint no se si es car o cars
	    public ResponseEntity<List<Cars>> getCars(@PathVariable("userId") int userId){

	          Users user = userService.getUserById(userId);
	            if(user==null)   return ResponseEntity.notFound().build();
	           List<Cars>  cars=userService.getCars(userId);
	          return  ResponseEntity.ok(cars);
	           
	    }
	    

         @GetMapping("/bikes/{userId}")                                           // ojo el endpoint no se si es bike o bikes
         public ResponseEntity<List<Bikes>> getBikes(@PathVariable("userId") int userId){

                  Users user = userService.getUserById(userId);
                   if(user==null)
                   return ResponseEntity.notFound().build();
                   List<Bikes>  bikes=userService.getBikes(userId);
                   return  ResponseEntity.ok(bikes);
       
         }
         
         //video 4
         
         @PostMapping("/savecar/{userId}")
         public ResponseEntity<Cars> saveCar(@PathVariable("userId") int userId, @RequestBody Cars car){
        	 Users user = userService.getUserById(userId);
        	 if(user == null)
                 return ResponseEntity.notFound().build();
            Cars carNew = userService.saveCar(userId, car);
            return ResponseEntity.ok(carNew);

         }
	    
         @PostMapping("/savebike/{userId}")
          public ResponseEntity<Bikes> saveBike(@PathVariable("userId") int userId, @RequestBody Bikes bike){
        	 Users user = userService.getUserById(userId);
        	 if(user == null)
                   return ResponseEntity.notFound().build(); 
        	  Bikes bikeNew = userService.saveBike(userId, bike);
              return ResponseEntity.ok(bikeNew);

         }
         
         
         @GetMapping("/getAll/{userId}")
         public ResponseEntity<Map<String, Object>> getAllVehicles(@PathVariable("userId") int userId){
        	 
        	 Map<String, Object> result= userService.getUserAndVehicles(userId);
        	 return ResponseEntity.ok(result);        	 
        	 
         }
         
         
         
         
         
         
         
         
         

}
