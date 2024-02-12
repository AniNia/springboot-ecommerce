package com.ecommerce.ecommercespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommercespringboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}
