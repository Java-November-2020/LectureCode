package com.matthew.cars.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.matthew.cars.models.User;
import com.matthew.cars.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> class) {
		return User.class.equals(class);
	}
	
	public void validate(Object target, Error error) {
		User user = (User) target;
		
		// Make Sure Password and Confirm Password matches
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			error.rejectValue("password", "Match");
		}
		
		// Make sure Email is Unique in the Database
		if(this.uRepo.existsByEmail(user.getEmail())) {
			error.rejectValue("email", "Unique");
		}
		
	}
}
