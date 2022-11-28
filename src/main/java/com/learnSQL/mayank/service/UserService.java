package com.learnSQL.mayank.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learnSQL.mayank.domain.User;

@Service
public interface UserService {
	
	public User save(User user);

    public Optional<User> findUserByEmail(String email);
    
	public Boolean authenticate(String username, String password);

}
