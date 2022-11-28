package com.learnSQL.mayank.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserDetailService extends UserDetailsService {

	public UserDetails loadUserByUsername(String email);
}
