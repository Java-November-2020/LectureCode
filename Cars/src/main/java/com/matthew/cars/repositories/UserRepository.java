package com.matthew.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.cars.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	
}
