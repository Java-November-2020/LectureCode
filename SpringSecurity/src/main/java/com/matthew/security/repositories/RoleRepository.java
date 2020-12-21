package com.matthew.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matthew.security.models.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	List<Role> findByName(String name);
	List<Role> findAll();
}
