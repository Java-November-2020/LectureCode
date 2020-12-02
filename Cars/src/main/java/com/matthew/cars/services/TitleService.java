package com.matthew.cars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.cars.models.Title;
import com.matthew.cars.repositories.TitleRepository;

@Service
public class TitleService {
	@Autowired
	private TitleRepository tRepo;
	
	//Create
	public Title create(Title title) {
		return this.tRepo.save(title);
	}
}
