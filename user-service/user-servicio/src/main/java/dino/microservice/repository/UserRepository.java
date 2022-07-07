package dino.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dino.microservice.entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
