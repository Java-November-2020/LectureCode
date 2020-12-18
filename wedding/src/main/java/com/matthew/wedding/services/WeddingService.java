package com.matthew.wedding.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.wedding.modlels.User;
import com.matthew.wedding.modlels.Wedding;
import com.matthew.wedding.repositories.WeddingRepository;

@Service
public class WeddingService {
	@Autowired
	private WeddingRepository wRepo;
	
	// Get All Weddings
	public List<Wedding> getWeddings(){
		return this.wRepo.findAll();
	}
	
	// Get One Wedding
	public Wedding getById(Long id) {
		return this.wRepo.findById(id).orElse(null);
	}
	
	// Create Wedding
	public Wedding create(Wedding wedding) {
		return this.wRepo.save(wedding);
	}
	
	// Update Wedding
	public Wedding udpate(Wedding wedding) {
		return this.wRepo.save(wedding);
	}
	
	// Delete Wedding
	public void delete(Long id) {
		this.wRepo.deleteById(id);
	}
	
	// Add User As Guest Of Wedding
	public void addGuest(Wedding wedding, User user) {
		//Retrieve current list of RSVP's
		List<User> currGuests = wedding.getGuests();
		// Add The User to that list
		currGuests.add(user);
		// Save The List and Update the Wedding
		this.wRepo.save(wedding);

	}
	
	
	// Remove User As Guest Of Wedding
	public void removeGuest(Wedding wedding, User user) {
		//Retrieve current list of RSVP's
		List<User> currGuests = wedding.getGuests();
		// Add The User to that list
		currGuests.remove(user);
		// Save The List and Update the Wedding
		this.wRepo.save(wedding);

	}
	
}
