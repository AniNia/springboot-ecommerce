package com.ecommerce.ecommercespringboot.service;

import com.ecommerce.ecommercespringboot.exception.UserException;
import com.ecommerce.ecommercespringboot.model.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User fintUserProfileByJWT(String jwt) throws UserException;

}
