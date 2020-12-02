package com.matthew.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.cars.models.Title;

@Repository
public interface TitleRepository extends CrudRepository<Title, Long>{

}
