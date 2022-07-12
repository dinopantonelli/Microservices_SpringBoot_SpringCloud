package dino.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dino.microservice.entity.Bikes;
@Repository
public interface BikesRepository extends JpaRepository<Bikes, Integer>{

	List<Bikes> findByUserId(int id);

}
