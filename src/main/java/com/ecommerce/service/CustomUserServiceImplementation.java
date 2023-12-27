package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class CustomUserServiceImplementation implements UserDetailsService{
	
	private UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public CustomUserServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("user not found with email: " + username);
		}
		
		
		String encodedPassword = user.getPassword();
		
        if (!passwordEncoder.matches(user.getPassword(), encodedPassword)) {
            encodedPassword = passwordEncoder.encode(user.getPassword()); // Encode the password
            user.setPassword(encodedPassword);
            userRepository.save(user); // Save the updated user with the encoded password
        }
        
		List<GrantedAuthority> authorities = new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(user.getEmail(), encodedPassword, authorities);
	}

}
