package com.learnSQL.mayank.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.service.UserDetailService;
import com.learnSQL.mayank.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email){
		Optional<User> user = userService.findUserByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), user.get().isEnabled(), true, true, true, user.get().getAuthorities());
	}

}
