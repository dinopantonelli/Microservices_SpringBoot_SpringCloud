package dino.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dino.microservice.entity.Cars;
import dino.microservice.repository.CarsRepository;

@Service
public class CarsService {
	
	
	@Autowired
	CarsRepository carsRepository;
	
	public List<Cars> getAll() {
		   return carsRepository.findAll();
		}

		public Cars getCarsById(int id){
		  return carsRepository.findById(id).orElse(null);
		}

		public Cars save(Cars car){                    //comparar con Cristian
		   Cars carNew = carsRepository.save(car);
		   return carNew;
		}
		
		public List<Cars> byUserId(int id){
			
			return carsRepository.findByUserId(id);
		}
	

}
