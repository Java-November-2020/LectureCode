package com.matthew.cars.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.cars.models.Car;
import com.matthew.cars.models.User;
import com.matthew.cars.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	// Register A New User
	public User registerUser(User user) {
		// Generate  aHash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		// Set The Hashed Password on the user's password field
		user.setPassword(hash);
		// Save the new user and their password to the database
		return this.uRepo.save(user);
	}
	
	// Authenticate / Login a user
	public boolean authenticateUser(String email, String password) {
		// make sure the user logging in is who they say they are
		// step 1: try and query for a user by email
		User user = this.uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}
		
		// Step 2: check provided email against email in database for user
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	public User getSingleUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
}
