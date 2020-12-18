package com.matthew.wedding.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.wedding.modlels.User;
import com.matthew.wedding.modlels.Wedding;
import com.matthew.wedding.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	// Method to Register User
	public User registerUser(User user) {
		// Generate a Hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		// Set The Hashed Password on the users password field
		user.setPassword(hash);
		// Save that new password along with the user to the database
		return this.uRepo.save(user);
	}
	
	// Login Existing User
	public boolean authenticateUser(String email, String password) {
		// Make sure the user logging in is who they say they are
		// Step 1: try and query for user by email
		User user = this.uRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		
		// Step 2: check provided email against email in db for user,
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	// Find By ID
	public User getById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
}
