package com.matthew.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.cars.models.Accessory;

@Repository
public interface AccessoryRepository extends CrudRepository<Accessory, Long> {

}
