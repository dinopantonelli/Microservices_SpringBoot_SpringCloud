package dino.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dino.microservice.entity.Bikes;
import dino.microservice.repository.BikesRepository;

@Service
public class BikesService {
	
	
	@Autowired
	BikesRepository bikesRepository;
	
	public List<Bikes> getAll() {
		   return bikesRepository.findAll();
		}

		public Bikes getBikesById(int id){
		  return bikesRepository.findById(id).orElse(null);
		}

		public Bikes save(Bikes bike){                    //comparar con Cristian
		   Bikes bikeNew = bikesRepository.save(bike);
		   return bikeNew;
		}

		public List<Bikes> byUserId(int id) {
			
			return bikesRepository.findByUserId(id);
		}
	

}
