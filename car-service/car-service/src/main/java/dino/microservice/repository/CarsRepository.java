package dino.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dino.microservice.entity.Cars;
@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer>{
	
	List<Cars> findByUserId(int userId);

}
