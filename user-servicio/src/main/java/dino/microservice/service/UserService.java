package dino.microservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dino.microservice.entity.Users;
import dino.microservice.feignclients.BikeFeignClient;
import dino.microservice.feignclients.CarFeignClient;
import dino.microservice.model.Bikes;
import dino.microservice.model.Cars;
import dino.microservice.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository userRepository;
	

    @Autowired
    RestTemplate restTemplate;
    
    @Autowired  
    CarFeignClient carFeignClient;
    
    @Autowired  
    BikeFeignClient bikeFeignClient;
	
	public List<Users> getAll() {
		   return userRepository.findAll();
		}

		public Users getUserById(int id){
		  return userRepository.findById(id).orElse(null);
		}

		public Users save(Users user){                    //comparar con Cristian
		   Users userNew = userRepository.save(user);
		   return userNew;
	}
		
		
		  public List<Cars>  getCars (int userId){          
		        List<Cars> cars=restTemplate.getForObject("http://car-service/cars/byuser/" + userId, List.class);   //aca le pasamos la url, que es el getById del Controller del proyecto Car
		         return cars;
		       }


		  public List<Bikes>  getBikes (int userId){            
		        List<Bikes> bikes = restTemplate.getForObject("http://bike-service/bikes/byuser/" + userId, List.class);   //aca le pasamos la url, que es el getById del Controller del proyecto Car
		         return bikes;
		       }
		  
		  
		  
		  //video 4
		  public Cars saveCar(int userId, Cars car){     
		        car.setUserId(userId);
		        Cars carNew =carFeignClient.saveCarfromFeign(car);     //llamamos al metodo saveCarfromFeign  del CarFeignClient              
		        return carNew;
		    }
		
		  public Bikes saveBike(int userId, Bikes bike){     
		        bike.setUserId(userId);
		        Bikes bikeNew =bikeFeignClient.saveBikefromFeign(bike);     //llamamos al metodo saveCarfromFeign  del CarFeignClient              
		        return bikeNew;
		    }
		  
		  
		  
		  
		   public Map<String, Object> getUserAndVehicles(int userId){
	           Map<String, Object> result = new HashMap<>();
	           Users user = userRepository.findById(userId).orElse(null);
	            if(user == null){
	             result.put("Mensaje", "no existe el usuario");
	             return result;
	            }
	           result.put("User", user);
	           List<Cars> cars = carFeignClient.getCars(userId);
	            if(cars.isEmpty())
	               result.put("Cars", "ese user no tiene coches");
	             else
	               result.put("Cars",cars);  
	           List<Bikes>  bikes =bikeFeignClient.getBikes(userId);
	            if(bikes.isEmpty())
	               result.put("Bikes", "ese user no tiene motos");
	             else
	           result.put("Bikes",bikes);
	           return result;
	      }

		  
		  
		  
		  
	

}
