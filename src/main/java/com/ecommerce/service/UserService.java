package com.ecommerce.service;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User fintUserProfileByJWT(String jwt) throws UserException;

}
