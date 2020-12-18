package com.matthew.wedding.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.wedding.modlels.Wedding;

@Repository
public interface WeddingRepository extends CrudRepository<Wedding, Long>{
	List<Wedding> findAll();
}
