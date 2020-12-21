package com.matthew.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.matthew.security.models.User;
import com.matthew.security.repositories.RoleRepository;
import com.matthew.security.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private RoleRepository rRepo;
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRoles(rRepo.findByName("ROLE_USER"));
		this.uRepo.save(user);
	}
	
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRoles(rRepo.findByName("ROLE_ADMIN"));
		this.uRepo.save(user);
	}
	
    public User findByUsername(String username) {
        return uRepo.findByUsername(username);
    }
	
}
